package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("events")
public class EventController {

    @RequestMapping("")
    public String login(HttpServletRequest request) {
        return "events";
    }
}
