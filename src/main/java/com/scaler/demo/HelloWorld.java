package com.scaler.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("")
    public String hello(){
        return "Hello! Welcome to Psych Game!!!!!!!!!!!!";
    }
}
