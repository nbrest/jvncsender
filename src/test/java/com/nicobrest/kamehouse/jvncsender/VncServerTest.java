package com.nicobrest.kamehouse.jvncsender;

import java.net.UnknownHostException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VncServerTest {

  @Test
  public void sendTextTest() {
    Assertions.assertThrows(
        UnknownHostException.class,
        () -> {
          VncServer vncServer = new VncServer("invalid-host", 5900, "");
          vncServer.sendText("madamada");
        }
    );
  }
}