package com.pm.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  @GetMapping("hello")
  public String hello() {
    return "Hello Spring";
  }

  @GetMapping("/welcome")
  public String welcome() {
    return "Welcome to Quarkus";
  }
}
