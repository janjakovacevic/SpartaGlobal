package com.sparta.jk.spring.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("name", "Manish");
        return "index";
    }

}
