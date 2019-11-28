package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.Wager;
import com.example.sportsbetting.database.service.PlayerService;
import com.example.sportsbetting.database.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("")
public class AppController {
    @Autowired
    PlayerService playerService;
    @Autowired
    WagerService wagerService;

    @RequestMapping("")
    public String index(Model model) {
        Wager wager = new Wager.Builder()
                .setAmount(new BigDecimal(1000))
                .setWin(false)
                .build();

        wagerService.add(wager);

        List<Wager> wagers = wagerService.getBets();
        model.addAttribute("wagers", wagers);
        return "index";
    }

    @GetMapping("/{id}")
    public Integer getById(@PathVariable(required = true) int id) {
        // return playerService.getPlayers().size();
        return 0;
    }
}
