package be.jedi.jvncsender;

import org.junit.jupiter.api.Test;

public class VncSenderTest {

  @Test
  public void sendTextTest() {
    VncSender vncSender = new VncSender("niko-w", 5900, "");
    vncSender.sendText("madamada");
  }
  //
}