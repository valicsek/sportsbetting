package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.Currency;
import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.model.Wager;
import com.example.sportsbetting.database.service.PlayerService;
import com.example.sportsbetting.database.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
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

        Player player = new Player.Builder()
                .setEmail("asdy@gmail.com")
                .setPassword("asd")
                .setName("David")
                .setAccountNumber(1)
                .setBalance(new BigDecimal(1000))
                .setBirth(LocalDate.of(2014, Month.JANUARY, 1))
                .setCurrency(Currency.HUF)
                .build();

        // playerService.add(player);
        // wagerService.add(wager);

        List<Wager> wagers = wagerService.getWagers();
        model.addAttribute("wagers", wagers);
        model.addAttribute("player", player);
        return "index";
    }

}
