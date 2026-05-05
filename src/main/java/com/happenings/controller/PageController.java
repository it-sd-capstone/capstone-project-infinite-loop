package com.happenings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // HOME
    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    // DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    // ALL EVENTS
    @GetMapping("/allEvents")
    public String allEvents() {
        return "allEvents";
    }

    // MY EVENTS
    @GetMapping("/myEvents")
    public String myEvents() {
        return "myEvents";
    }

    // CREATE EVENT
    @GetMapping("/createEvent")
    public String createEvent() {
        return "createEvent";
    }

    // SAVED EVENTS
    @GetMapping("/saved")
    public String saved() {
        return "saved";
    }

    // PROFILE
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    // LOGIN
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // REGISTER
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}