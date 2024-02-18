package com.nicobrest.kamehouse.jvncsender;

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
public class VncSenderMain {

  private final static Logger logger = LoggerFactory.getLogger(VncSenderMain.class);

  /**
   * @param args
   */
  Options options = new Options();
  Options cmdoptions = new Options();

  CommandLine cmdLine;

  public static void main(String[] args) {
    try {
      logger.trace("Started executing main jvncsender");
      VncSenderMain sender = new VncSenderMain();
      sender.setupOptions();
      sender.validateArgs(args);

      String[] vncText = sender.cmdLine.getOptionValues("text");
      String vncHost = sender.cmdLine.getOptionValue("host");
      String vncPassword = sender.cmdLine.getOptionValue("password");
      Integer vncPort = Integer.parseInt(sender.cmdLine.getOptionValue("port"));
      String vncMouseClick = sender.cmdLine.getOptionValue("mouseClick");

      VncSender vncSender = new VncSender(vncHost, vncPort, vncPassword);

      if (sender.cmdLine.hasOption("wait")) {
        vncSender.setVncWaitTime(Integer.parseInt(sender.cmdLine.getOptionValue("wait")));
      }

      if (vncMouseClick != null) {
        String[] mouseClickParams = vncMouseClick.split(",");
        int positionX = Integer.parseInt(mouseClickParams[0]);
        int positionY = Integer.parseInt(mouseClickParams[1]);
        int clickCount = Integer.parseInt(mouseClickParams[2]);
        vncSender.sendMouseClick(positionX, positionY, clickCount);
      } else {
        vncSender.sendText(vncText);
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

    Option mouseClick = OptionBuilder.withArgName("mouseClick").hasArgs()
        .withDescription("positionX,positionY,numberOfClicks").create("mouseClick");
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
            "java -jar jvncsender.jar [-list] [-help] -host <hostname> -port <port> -text <text> [-password <password>] [-wait <seconds>]",
            "", options,
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

      if (cmdLine.hasOption("mouseClick")) {
        String mouseClick = cmdLine.getOptionValue("mouseClick");
        if (!mouseClick.matches("\\d+,\\d+,\\d+")) {
          logger.error("Invalid mouseClick option value: " + mouseClick);
          System.exit(-1);
        }
      } else {
        if (!cmdLine.hasOption("text")) {
          logger.error("Either mouseClick or text need to be passed as arguments");
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
}
