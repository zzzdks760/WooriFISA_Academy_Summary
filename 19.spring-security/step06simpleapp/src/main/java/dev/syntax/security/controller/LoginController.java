package dev.syntax.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/custom/login")
    public String login() {

        return "login";
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}
