package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/events")
    public String events() {
        return "events";
    }
}
