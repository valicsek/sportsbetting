package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logout")
public class LogoutController {

    @RequestMapping(value = "")
    public String logout() {
        return "logout";
    }

}