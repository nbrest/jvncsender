package com.nicobrest.kamehouse.jvncsender;

import org.junit.jupiter.api.Test;

public class VncServerMainTest {

  @Test
  public void executeVncSenderMainTest() {
    String[] args = {
        "-host", "niko-w",
        "-port", "5900",
        "-text", "<ESC>",
        "-password", ""
    };
    VncServerMain.main(args);
  }
}