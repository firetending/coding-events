package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventsData {
    private static final Map<Integer,Event> events = new HashMap();

    public static Collection<Event> getAll() {
        return events.values();
    }

    public static Event getById(int id) {
        return events.get(id);
    }

    public static void add(Event newEvent) {
        events.put(newEvent.getId(),newEvent);
    }

    public static void remove(int id) {
        if (events.containsKey(id)) {
            events.remove(id);
        }
    }
}
