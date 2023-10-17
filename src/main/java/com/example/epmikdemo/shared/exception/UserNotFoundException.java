package com.example.epmikdemo.shared.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String msg) {
    super(msg);
  }
}
