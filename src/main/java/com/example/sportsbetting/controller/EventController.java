package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.FootballSportEvent;
import com.example.sportsbetting.database.service.FootballSportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    FootballSportEventService footballSportEventService;

    @RequestMapping("")
    public String login(Model model) {
        List<FootballSportEvent> footballSportEventList = footballSportEventService.getFootballSportEvents();
        model.addAttribute("events", footballSportEventList);

        return "events";
    }
}
