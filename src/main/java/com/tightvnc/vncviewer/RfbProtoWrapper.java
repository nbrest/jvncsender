package com.tightvnc.vncviewer;

import java.io.IOException;

/**
 * Wrapper class to access RfbProto functionality outside com.tightvnc.vncviewer package.
 *
 * @author nbrest
 */
public class RfbProtoWrapper {

  public static final int SecTypeTight = RfbProto.SecTypeTight;
  public static final int AuthNone = RfbProto.AuthNone;
  public static final int AuthVNC = RfbProto.AuthVNC;

  RfbProto rfbProto;

  public RfbProtoWrapper(String h, int p, VncViewer v) throws IOException {
    rfbProto = new RfbProto(h, p, v);
  }

  public void setEventBufLen(int eventBufLen) {
    rfbProto.eventBufLen = eventBufLen;
  }

  public void writeKeyEvent(Integer key, boolean down) {
    rfbProto.writeKeyEvent(key, down);
  }

  public void write(int b) throws IOException {
    rfbProto.os.write(b);
  }

  public void write(byte[] payload, int offset, int length) throws IOException {
    rfbProto.os.write(payload, offset, length);
  }

  public byte[] getEventBuf() {
    return rfbProto.eventBuf;
  }

  public int getEventBufLen() {
    return rfbProto.eventBufLen;
  }

  public void flush() throws IOException {
    rfbProto.os.flush();
  }

  public void close() throws IOException {
    rfbProto.os.close();
  }

  public void writeVersionMsg() throws IOException {
    rfbProto.writeVersionMsg();
  }

  public void readVersionMsg() throws Exception {
    rfbProto.readVersionMsg();
  }

  public int serverMajor() {
    return rfbProto.serverMajor;
  }

  public int serverMinor() {
    return rfbProto.serverMinor;
  }

  public int clientMajor() {
    return rfbProto.clientMajor;
  }

  public int clientMinor() {
    return rfbProto.clientMinor;
  }

  public int negotiateSecurity() throws Exception {
    return rfbProto.negotiateSecurity();
  }

  public void setupTunneling() throws IOException {
    rfbProto.setupTunneling();
  }

  public int negotiateAuthenticationTight() throws Exception {
    return rfbProto.negotiateAuthenticationTight();
  }

  public void authenticateNone() throws Exception {
    rfbProto.authenticateNone();
  }

  public void authenticateVNC(String password) throws Exception {
    rfbProto.authenticateVNC(password);
  }
}
