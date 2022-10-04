package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventsData;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

    //lives at /events
    @GetMapping
    public String events(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventsData.getAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title","Create Event");
//        model.addAttribute(new Event());
        model.addAttribute("categories", EventType.values());
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEvent(@ModelAttribute @Valid Event newEvent,
                                     Errors errors,
                                     Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title","Create Event");
            model.addAttribute("categories", EventType.values());
            return "events/create";
        }
        EventsData.add(newEvent);
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
