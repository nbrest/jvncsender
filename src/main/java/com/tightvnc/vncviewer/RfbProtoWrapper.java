package com.tightvnc.vncviewer;

import java.io.IOException;

/**
 * Wrapper class to access RfbProto functionality outside com.tightvnc.vncviewer package.
 *
 * @author nbrest
 */
public class RfbProtoWrapper extends RfbProto {

  public static final int SecTypeTight = RfbProto.SecTypeTight;
  public static final int AuthNone = RfbProto.AuthNone;
  public static final int AuthVNC = RfbProto.AuthVNC;

  public RfbProtoWrapper(String host, int port, VncViewer vncViewer) throws IOException {
    super(host, port, vncViewer);
  }

  public void setEventBufLen(int eventBufLen) {
    this.eventBufLen = eventBufLen;
  }

  public void writeKeyEvent(Integer key, boolean down) {
    super.writeKeyEvent(key, down);
  }

  public void write(int b) throws IOException {
    super.os.write(b);
  }

  public void write(byte[] payload, int offset, int length) throws IOException {
    super.os.write(payload, offset, length);
  }

  public byte[] getEventBuf() {
    return super.eventBuf;
  }

  public int getEventBufLen() {
    return super.eventBufLen;
  }

  public void flush() throws IOException {
    super.os.flush();
  }

  public void osClose() throws IOException {
    super.os.close();
  }

  public void writeVersionMsg() throws IOException {
    super.writeVersionMsg();
  }

  public void readVersionMsg() throws Exception {
    super.readVersionMsg();
  }

  public int serverMajor() {
    return super.serverMajor;
  }

  public int serverMinor() {
    return super.serverMinor;
  }

  public int clientMajor() {
    return super.clientMajor;
  }

  public int clientMinor() {
    return super.clientMinor;
  }

  public int negotiateSecurity() throws Exception {
    return super.negotiateSecurity();
  }

  public void setupTunneling() throws IOException {
    super.setupTunneling();
  }

  public int negotiateAuthenticationTight() throws Exception {
    return super.negotiateAuthenticationTight();
  }

  public void authenticateNone() throws Exception {
    super.authenticateNone();
  }

  public void authenticateVNC(String password) throws Exception {
    super.authenticateVNC(password);
  }
}
