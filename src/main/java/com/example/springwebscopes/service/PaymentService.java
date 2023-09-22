package com.example.springwebscopes.service;

import org.springframework.stereotype.Service;

import com.example.springwebscopes.Exceptions.NotEnoughMoneyException;
import com.example.springwebscopes.Model.PaymentDetails;

@Service
public class PaymentService {
  public PaymentDetails ProcessPayment()
  {
    throw new NotEnoughMoneyException();
  }
}
