package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    PlayerService service;

    @RequestMapping("")
    public String login() {
        return "login";
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable(required = true) long id) {
    }
}
