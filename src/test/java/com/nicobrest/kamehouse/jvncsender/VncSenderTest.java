package com.nicobrest.kamehouse.jvncsender;

import java.net.UnknownHostException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VncSenderTest {

  @Test
  public void sendTextTest() {
    Assertions.assertThrows(
        UnknownHostException.class,
        () -> {
          VncSender vncSender = new VncSender("invalid-host", 5900, "");
          vncSender.sendText("madamada");
        }
    );
  }
}