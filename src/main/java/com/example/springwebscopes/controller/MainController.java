package com.example.springwebscopes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springwebscopes.service.LoggedUserManagementService;
import com.example.springwebscopes.service.LogincountService;

@Controller
public class MainController {

  private final LoggedUserManagementService loggedUserManagementService;
  private final LogincountService logincountService;

  public MainController(LoggedUserManagementService lums, LogincountService lcs)
  {
    this.loggedUserManagementService = lums;
    this.logincountService =lcs;
  }
                    
  @GetMapping("/main")
  public String home(@RequestParam(required = false) String logout, Model model){
    
    
    //if logout value is present, empty username . ends user session
    if (logout!=null)
    {
      loggedUserManagementService.setUsername(null);
    }

    //if the main page is directly accessed, check for username from lums 
    //and send to login page if no username
    String username=loggedUserManagementService.getUsername();
    if(username==null)
    {
      return "redirect:/login";
    }

    //get username from lums to send it to main.html  
    model.addAttribute("username", username);
    model.addAttribute("logincounter", logincountService.getLoginCount());
    return "main.html";
  }
}
