package be.jedi.jvncsender;

import org.junit.jupiter.api.Test;

public class VncSenderMainTest {

  @Test
  public void executeVncSenderMainTest() {
    String[] args = {
        "-host", "niko-w",
        "-port", "5900",
        "-text", "madamada",
        "-password", ""
    };
    VncSenderMain.main(args);
  }
  //
}