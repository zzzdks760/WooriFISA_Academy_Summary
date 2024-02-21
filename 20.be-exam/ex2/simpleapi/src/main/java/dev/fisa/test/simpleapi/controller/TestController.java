package dev.fisa.test.simpleapi.controller;

import dev.fisa.test.simpleapi.model.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/status")
    public Test show() {
        Test test = new Test(LocalDateTime.now(), "Service is Running");
        System.out.println("test = " + test.getCurrentDate() + " " + test.getStatus());
        return test;
    }

}
