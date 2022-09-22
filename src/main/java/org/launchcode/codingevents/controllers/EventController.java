package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    //lives at /events
    @GetMapping()
    public String events(Model model) {
        List<String> events = new ArrayList<>();
        events.add("Ice Cream Social");
        events.add("Cocktail Mixer");
        events.add("Hack-A-Thon");
        events.add("Brunch");
        model.addAttribute("events",events);
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        return "events/create";
    }
}
