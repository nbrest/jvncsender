package com.nicobrest.kamehouse.jvncsender;

import java.util.Locale;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Forked from: https://github.com/jsundqvist/jvncsender
 */
public class VncServerMain {

  private final static Logger logger = LoggerFactory.getLogger(VncServerMain.class);

  /**
   * @param args
   */
  Options options = new Options();
  Options cmdoptions = new Options();

  CommandLine cmdLine;

  public static void main(String[] args) {
    try {
      logger.trace("Started executing main jvncsender");
      VncServerMain sender = new VncServerMain();
      sender.setupOptions();
      sender.validateArgs(args);

      String[] vncText = sender.cmdLine.getOptionValues("text");
      String vncHost = sender.cmdLine.getOptionValue("host");
      String vncPassword = sender.cmdLine.getOptionValue("password");
      Integer vncPort = Integer.parseInt(sender.cmdLine.getOptionValue("port"));
      String vncMouseClick = sender.cmdLine.getOptionValue("mouseClick");

      VncServer vncServer = new VncServer(vncHost, vncPort, vncPassword);

      if (sender.cmdLine.hasOption("wait")) {
        vncServer.setVncWaitTime(Integer.parseInt(sender.cmdLine.getOptionValue("wait")));
      }

      if (vncMouseClick != null) {
        String[] mouseClickParams = vncMouseClick.split(",");
        MouseButton mouseButton = MouseButton.valueOf(mouseClickParams[0].toUpperCase(Locale.ROOT));
        int positionX = Integer.parseInt(mouseClickParams[1]);
        int positionY = Integer.parseInt(mouseClickParams[2]);
        int clickCount = Integer.parseInt(mouseClickParams[3]);
        vncServer.sendMouseClick(mouseButton, positionX, positionY, clickCount);
      }
      if (vncText != null) {
        vncServer.sendText(vncText);
      }
      logger.trace("Finished executing main jvncsender");
    } catch (Exception e) {
      logger.error("Error executing jvncsender", e);
    }
  }

  void setupOptions() {

    Option host = OptionBuilder.withArgName("hostname").hasArg()
        .withDescription("hostname or ip-address to send it to").create("host");
    host.setRequired(true);
    options.addOption(host);

    Option port = OptionBuilder.withArgName("port").hasArg()
        .withDescription("port to connect to f.i. 5900")
        .create("port");
    port.setRequired(true);
    options.addOption(port);

    options.addOption(
        OptionBuilder.withArgName("password").hasArg().withDescription("password to use")
            .create("password"));
    options.addOption(OptionBuilder.withArgName("seconds").hasArg()
        .withDescription("seconds to wait in between sending different texts (default=1s)")
        .create("wait"));

    Option text = OptionBuilder.withArgName("text").hasArgs()
        .withDescription("text to send, (can be use multiple times)").create("text");
    text.setRequired(false);
    options.addOption(text);

    Option mouseClick = OptionBuilder.withArgName("clickParams").hasArgs()
        .withDescription("[LEFT|RIGHT],positionX,positionY,numberOfClicks").create("mouseClick");
    text.setRequired(false);
    options.addOption(mouseClick);

    Option help = new Option("help", "print this message");
    options.addOption(help);
    cmdoptions.addOption(help);

    Option list = new Option("list", "list keymappings");
    options.addOption(list);
    cmdoptions.addOption(list);
  }

  public void printHelp() {
    // automatically generate the help statement
    HelpFormatter formatter = new HelpFormatter();
    formatter.setWidth(150);
    formatter.setOptionComparator(null);

    formatter
        .printHelp(
            "java -jar jvncsender.jar options",
            "Options:", options,
            "\ntext can also take special keys f.i. like \"linux ks=ks.cfg<RETURN>\"\n use -list options to see all keymappings	\n");
  }

  void validateArgs(String[] args) {

    // Check the commands
    try {
      CommandLineParser parser = new GnuParser();
      // parse the command line arguments
      cmdLine = parser.parse(cmdoptions, args);

      if (cmdLine.hasOption("help")) {
        this.printHelp();
        System.exit(0);
      }

      if (cmdLine.hasOption("list")) {
        VncMappings.printMaps();
        System.exit(0);
      }

    } catch (ParseException exp) {
      // We ignore this error as it's probably complaining about arguments missing

    }

    // now check the arguments
    try {
      CommandLineParser parser = new GnuParser();
      // parse the command line arguments
      cmdLine = parser.parse(options, args);

      if (hasMouseClick()) {
        validateMouseClick();
      } else {
        if (!cmdLine.hasOption("text")) {
          logger.error("Either mouse[Left|Right]Click or text need to be passed as arguments");
          System.exit(-1);
        }
      }
    } catch (ParseException e) {

      // oops, something went wrong
      this.printHelp();

      logger.error("Parsing failed.  Reason: ", e);

      System.exit(-1);
    }

  }

  private boolean hasMouseClick() {
    return cmdLine.hasOption("mouseClick");
  }

  private void validateMouseClick() {
    String mouseClick = cmdLine.getOptionValue("mouseClick");
    if (!mouseClick.matches("(LEFT|RIGHT),\\d+,\\d+,\\d+")) {
      logger.error("Invalid mouseClick option value: " + mouseClick);
      System.exit(-1);
    }
  }
}
