package com.happenings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @GetMapping("/api/events")
    public List<String> getEvents() {
        return List.of("Music Festival", "Art Fair", "Food Truck Rally");
    }
}