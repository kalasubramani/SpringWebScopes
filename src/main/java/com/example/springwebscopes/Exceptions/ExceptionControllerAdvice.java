package com.example.springwebscopes.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springwebscopes.Model.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {
  @ExceptionHandler(NotEnoughMoneyException.class)
  public ResponseEntity<ErrorDetails> NotEnoughMoneyExceptionHandler(){
    ErrorDetails errDetails = new ErrorDetails();
    errDetails.setErrorMessage("Oops !! There is no enough money to process this Payment at this time.");
    return ResponseEntity
          .badRequest()
          .body(errDetails);
  }
}
