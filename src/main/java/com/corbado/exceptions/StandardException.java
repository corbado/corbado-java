package com.corbado.exceptions;

/** Custom exception class for standard exceptions. */
public class StandardException extends Exception {

  private static final long serialVersionUID = -1528458577429647143L;

  public StandardException(final String string) {
    super(string);
  }
}
