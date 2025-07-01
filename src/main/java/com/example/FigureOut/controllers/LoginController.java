package com.example.FigureOut.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/customLoginPage")
    public String loginPage() {
        return "customLogin";
    }
}
