package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventsData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("events")
public class EventController {

    //lives at /events
    @GetMapping
    public String events(Model model) {
//        events.add("Ice Cream Social");
//        events.add("Cocktail Mixer");
//        events.add("Hack-A-Thon");
//        events.add("Brunch");
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventsData.getAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEvent(@ModelAttribute Event newEvent) {
        if (!newEvent.getName().isEmpty()) {
            EventsData.add(newEvent);
        }
        return "redirect:"; //redirects to root of controller
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events", EventsData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEvent(@RequestParam(required = false) int[] eventIds) {
        if (eventIds!=null) {
            for (int id : eventIds) {
                EventsData.remove(id);
            }
        }
        return "redirect:";
    }

}
