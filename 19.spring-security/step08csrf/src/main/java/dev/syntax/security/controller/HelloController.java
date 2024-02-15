package dev.syntax.security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String helloWithGET() {
        return "Hello! with GET Method";
    }

    @PostMapping
    public String helloWithPOST() {
        return "Hello! with POST Method";
    }

    @PutMapping
    public String helloWithPUT() {
        return "Hello! with PUT Method";
    }

    @DeleteMapping
    public String helloWithDELETE() {
        return "Hello! with DELETE Method";
    }
}