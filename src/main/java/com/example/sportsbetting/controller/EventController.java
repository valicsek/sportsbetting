package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("events")
public class EventController {

    @RequestMapping("")
    public String login() {
        return "events";
    }
}
