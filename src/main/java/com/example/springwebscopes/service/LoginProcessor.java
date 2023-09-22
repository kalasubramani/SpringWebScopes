package com.example.springwebscopes.service;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

  private final LoggedUserManagementService loggedinUMservice;
  private final LogincountService loginCountService;

  public LoginProcessor(LoggedUserManagementService lgusrmgmtSer, LogincountService lcs)
  {
    this.loggedinUMservice=lgusrmgmtSer;
    this.loginCountService =lcs;
  }
  
  String username;
  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  String password;

  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }

 
  public boolean validateLogin(){//(String UserName, String passWord) {
    String username = this.username;
    String password=this.password;
    boolean loginResult=false;

    loginCountService.incrementLoginCounter();;
    
    if ("nn".equals(username) && "pp".equals(password)) {
      loginResult= true;
      loggedinUMservice.setUsername(username);
    } else {
      loginResult= false;
    }
return loginResult;
  }
}
