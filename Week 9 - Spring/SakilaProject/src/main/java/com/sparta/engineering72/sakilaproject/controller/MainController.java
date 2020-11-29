package com.sparta.engineering72.sakilaproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/account")
    public String account(){
        return "account";
    }

}
