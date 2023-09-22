package com.example.springwebscopes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwebscopes.service.Country;

@RestController       
public class CountryController {
 
  @GetMapping("/france")
  public Country france()
  {
    Country c =Country.of("France", 67);
    return c;
  }

  @GetMapping("/getallcountries")
  public List<Country> getallcountries(){
    Country c1=Country.of("France", 62);
    Country c2 = Country.of("India",101);

    return List.of(c1,c2);
  }

  @GetMapping("/india")
  public ResponseEntity<Country> India()
  {
    Country c = Country.of("India", 62);
    return ResponseEntity
              .status(HttpStatus.ACCEPTED)
              .header("continent", "Asia")
              .header("capital","Delhi")
              .header("favourite food", "Idly")
              .body(c);

  }
}
