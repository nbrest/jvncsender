package com.nicobrest.kamehouse.jvncsender;

import java.awt.event.MouseEvent;

/**
 * Mouse button.
 *
 * @author nbrest
 */
public enum MouseButton {
  LEFT(MouseEvent.BUTTON1),
  RIGHT(MouseEvent.BUTTON3);

  int mouseEvent;

  MouseButton(int mouseEvent) {
    this.mouseEvent = mouseEvent;
  }

  /**
   * Get the MouseEvent value for the mouse button.
   */
  public int get() {
    return mouseEvent;
  }
}
