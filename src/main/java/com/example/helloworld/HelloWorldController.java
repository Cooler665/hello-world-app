package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        // Здесь будет логирование, которое позже отправляется в Kafka
        System.out.println("Hello, world!");
        return "Hello, world!";
    }
}
