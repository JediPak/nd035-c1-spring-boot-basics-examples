package com.example.mvc_basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage() {

        return "home";
    }

    @RequestMapping("/cat")
    public String getCatPage() {

        return "cat";
    }

}
