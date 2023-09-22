package com.example.springwebscopes.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwebscopes.Exceptions.NotEnoughMoneyException;
import com.example.springwebscopes.Model.ErrorDetails;
import com.example.springwebscopes.Model.PaymentDetails;
import com.example.springwebscopes.service.PaymentService;

@RestController
public class PaymentController {
  private final PaymentService paymentService;
  private static Logger logger =Logger.getLogger(PaymentController.class.getName()); 

  public PaymentController(PaymentService paymentSer)
  {
    this.paymentService=paymentSer;
  }

  @PostMapping("/payment")
  public ResponseEntity<?> makePayment()
  {
    try{
      PaymentDetails paymentDetails=paymentService.ProcessPayment();
      return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(paymentDetails);           
    }
    catch(NotEnoughMoneyException e)
    {
      ErrorDetails errDetails = new ErrorDetails();
      errDetails.setErrorMessage("Oops !! There is no enough money to process this Payment at this time.");
      return ResponseEntity
          .badRequest()
          .body(errDetails);
    }
  }

  @PostMapping("/paymentresponsebody")
  public ResponseEntity<PaymentDetails> makePayment( @RequestBody PaymentDetails paymentDetails )
  {
    logger.info("Received Payment of $" +paymentDetails.getAmount());

    paymentService.ProcessPayment();
    
    return ResponseEntity
          .status(HttpStatus.ACCEPTED)
          .body(paymentDetails);
  }
}
