package com.project.Avoar.util;

public class DawException extends Exception {
  private static final long serialVersionUID = -7669751088704144947L;

  public DawException(String message) {
    super(message);
  }

  public DawException(String message, Throwable cause) {
    super(message, cause);
  }
}
