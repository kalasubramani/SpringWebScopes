package com.example.springwebscopes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springwebscopes.service.LoggedUserManagementService;
import com.example.springwebscopes.service.LoginProcessor;

@Controller
public class LoginController {

 
  private final LoginProcessor loginProcessor;

  public LoginController(LoginProcessor loginProcessor )
  {
   
    this.loginProcessor=loginProcessor;
  }

  
  @RequestMapping("/login")
  public String GetloginCredentials()
  {
    return "login.html";
  }

  @PostMapping("/login")
  public String LoginPost(@RequestParam String username,
                          @RequestParam String Password,
                          Model model)
                          {
                            loginProcessor.setUsername(username);
                            loginProcessor.setPassword(Password);

                             //boolean loggedin=true;
                           boolean loggedin = loginProcessor.validateLogin();
                            if(loggedin)
                            {
                             model.addAttribute("message", "You are now logged in.");
                             return "redirect:/main";
                            }
                            // else{
                            //   model.addAttribute("message", "Login Failed.");
                            // }
                            model.addAttribute("message", "Login Failed.");
                            return "login.html";
                          }

}
