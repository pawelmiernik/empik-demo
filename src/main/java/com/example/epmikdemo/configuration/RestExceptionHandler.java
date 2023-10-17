package com.example.epmikdemo.configuration;

import com.example.epmikdemo.shared.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
class RestExceptionHandler {

  @ExceptionHandler({ UserNotFoundException.class })
  public ResponseEntity<Object> handleUserNotFound(RuntimeException ex) {
    log.error(ExceptionUtils.getStackTrace(ex));
    return new ResponseEntity<>(ex.getMessage(), createHeaders(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({ Exception.class, ConstraintViolationException.class })
  public ResponseEntity<Object> handleRuntime(RuntimeException ex) {
    log.error(ExceptionUtils.getStackTrace(ex));
    return new ResponseEntity<>(ex.getMessage(), createHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private static HttpHeaders createHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/text");
    return headers;
  }

}
