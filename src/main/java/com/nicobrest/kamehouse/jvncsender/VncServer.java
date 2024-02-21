package com.nicobrest.kamehouse.jvncsender;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Forked from: https://github.com/jsundqvist/jvncsender
 */
public class VncServer {

  private final static Logger logger = LoggerFactory.getLogger(VncServer.class);

  // Defaults to 1 second
  int vncWaitTime = 1;

  String vncHost;
  int vncPort;
  String vncPassword;

  public VncServer(String vncHost, int vncPort, String vncPassword) {
    super();
    this.vncHost = vncHost;
    this.vncPort = vncPort;
    this.vncPassword = vncPassword;
  }

  public void sendText(String vncText) throws Exception {
    String[] vncTextArray = new String[1];
    vncTextArray[0] = vncText;
    sendText(vncTextArray);
  }

  public void sendText(String... vncText) throws Exception {
    sendText(Arrays.asList(vncText));
  }

  public void sendText(Iterable<String> vncText) throws Exception {

    // Ignore Cert file
    // https://www.chemaxon.com/forum/ftopic65.html&highlight=jmsketch+signer

    VncSender vncSender = new VncSender(vncHost, vncPort, vncPassword);
    vncSender.open();
    for (String line : vncText) {
      logger.info("Sending text to vnc server {}:{}", vncHost, vncPort);
      vncSender.print(line);
      sleep(vncWaitTime);
    }
    vncSender.close();
  }

  /**
   * Send a mouse click to the vnc server.
   */
  public void sendMouseClick(MouseButton mouseButton, int positionX, int positionY, int clickCount)
      throws Exception {
    VncSender vncSender = new VncSender(vncHost, vncPort, vncPassword);
    vncSender.open();
    logger.info("Sending mouse click to vnc server {}:{}", vncHost, vncPort);
    vncSender.mouseClick(mouseButton, positionX, positionY, clickCount);
    sleep(vncWaitTime);
    vncSender.close();
  }

  void sleep(int seconds) {
    // We need to wait
    try {
      Thread.sleep(seconds * 1000);// sleep for 1000 ms
    } catch (InterruptedException ie) {
    }
  }

  public int getVncWaitTime() {
    return vncWaitTime;
  }

  public void setVncWaitTime(int vncWaitTime) {
    this.vncWaitTime = vncWaitTime;
  }

  public String getVncHost() {
    return vncHost;
  }

  public void setVncHost(String vncHost) {
    this.vncHost = vncHost;
  }

  public int getVncPort() {
    return vncPort;
  }

  public void setVncPort(int vncPort) {
    this.vncPort = vncPort;
  }

  public String getVncPassword() {
    return vncPassword;
  }

  public void setVncPassword(String vncPassword) {
    this.vncPassword = vncPassword;
  }

}
