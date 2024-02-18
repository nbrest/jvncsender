package com.tightvnc.vncviewer;

public class VncViewerWrapper extends VncViewer {

  public VncViewerWrapper(String host, int port, String password) {
    super();
    this.inAnApplet = false;
    this.inSeparateFrame = false;
    this.mainArgs = new String[]{"host", host, "port", String.valueOf(port)};
    this.passwordParam = password;
  }

  public void setRfb(RfbProto rfb) {
    super.rfb = rfb;
  }
}
