package com.example.FigureOut.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
