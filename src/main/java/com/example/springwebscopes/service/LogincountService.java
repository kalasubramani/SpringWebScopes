package com.example.springwebscopes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LogincountService {
  public int logincounter;

  public void incrementLoginCounter()
  {
    logincounter++;
  }
 
  public int getLoginCount()
  {
    return logincounter;
  }

}
