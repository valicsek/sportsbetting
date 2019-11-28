package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @RequestMapping("/")
    public String index(Model model) {
        List wagers = new ArrayList();
        wagers.add("Almafa");
        wagers.add("Sajt");
        wagers.add("Tojas");

        model.addAttribute("wagers", wagers);
        return "index";
    }

    @RequestMapping("/events")
    public String events() {
        return "events";
    }
}
