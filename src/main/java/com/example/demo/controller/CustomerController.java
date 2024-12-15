package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("Testing log4j, Hello World!");
        return "Testing testing, Hello World!";
    }
}