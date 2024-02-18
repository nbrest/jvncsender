package com.tightvnc.vncviewer;

import java.awt.event.MouseEvent;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wrapper class to access RfbProto functionality outside com.tightvnc.vncviewer package.
 *
 * @author nbrest
 */
public class RfbProtoWrapper extends RfbProto {

  private final static Logger logger = LoggerFactory.getLogger(RfbProtoWrapper.class);

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

  public void writePointerEvent(MouseEvent evt) throws IOException {
    int modifiers = evt.getModifiers();
    int mask2 = 2;
    int mask3 = 4;
    if (this.viewer != null && this.viewer.options != null
        && this.viewer.options.reverseMouseButtons2And3) {
      mask2 = 4;
      mask3 = 2;
    }

    if (evt.getID() == 501) {
      if ((modifiers & 8) != 0) {
        this.pointerMask = mask2;
        modifiers &= -9;
      } else if ((modifiers & 4) != 0) {
        this.pointerMask = mask3;
        modifiers &= -5;
      } else {
        this.pointerMask = 1;
      }
    } else if (evt.getID() == 502) {
      this.pointerMask = 0;
      if ((modifiers & 8) != 0) {
        modifiers &= -9;
      } else if ((modifiers & 4) != 0) {
        modifiers &= -5;
      }
    }

    this.eventBufLen = 0;
    this.writeModifierKeyEvents(modifiers);
    int x = evt.getX();
    int y = evt.getY();
    if (x < 0) {
      x = 0;
    }

    if (y < 0) {
      y = 0;
    }

    this.eventBuf[this.eventBufLen++] = 5;
    this.eventBuf[this.eventBufLen++] = (byte) this.pointerMask;
    this.eventBuf[this.eventBufLen++] = (byte) (x >> 8 & 255);
    this.eventBuf[this.eventBufLen++] = (byte) (x & 255);
    this.eventBuf[this.eventBufLen++] = (byte) (y >> 8 & 255);
    this.eventBuf[this.eventBufLen++] = (byte) (y & 255);
    if (this.pointerMask == 0) {
      this.writeModifierKeyEvents(0);
    }

    this.os.write(this.eventBuf, 0, this.eventBufLen);
  }


  /**
   * Override to avoid system out logging.
   */
  @Override
  void readSecurityResult(String authType) throws Exception {
    int securityResult = this.readU32();
    switch (securityResult) {
      case 0:
        logger.debug(authType + ": success");
        return;
      case 1:
        if (this.clientMinor >= 8) {
          this.readConnFailedReason();
        }

        throw new Exception(authType + ": failed");
      case 2:
        throw new Exception(authType + ": failed, too many tries");
      default:
        throw new Exception(authType + ": unknown result " + securityResult);
    }
  }
}
