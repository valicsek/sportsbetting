package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.model.Wager;
import com.example.sportsbetting.database.service.PlayerService;
import com.example.sportsbetting.database.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String index(Model model, HttpServletRequest request) {
        Wager wager = new Wager.Builder()
                .setAmount(new BigDecimal(1000))
                .setWin(false)
                .build();

        String username = ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        // Request the logged in user based on email address.
        Player player = playerService.getPlayerByEmail(username);
        List<Wager> wagers = wagerService.getWagers();

        model.addAttribute("wagers", wagers);
        model.addAttribute("player", player);
        return "index";
    }

}
