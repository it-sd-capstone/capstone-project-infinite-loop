package com.happenings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // -------------------------
    // HOME
    // -------------------------
    @GetMapping({"/", "/home"})
    public String home() {
        return "home"; // templates/home.html
    }

    // -------------------------
    // DASHBOARD
    // -------------------------
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // templates/dashboard.html
    }

    // -------------------------
    // ALL EVENTS
    // -------------------------
    @GetMapping("/allEvents")
    public String allEvents() {
        return "allEvents"; // templates/allEvents.html
    }

    // -------------------------
    // MY EVENTS
    // -------------------------
    @GetMapping("/myEvents")
    public String myEvents() {
        return "myEvents"; // templates/myEvents.html
    }

    // -------------------------
    // CREATE EVENT
    // -------------------------
    @GetMapping("/createEvent")
    public String createEvent() {
        return "createEvent"; // templates/createEvent.html
    }

    // -------------------------
    // SAVED EVENTS
    // -------------------------
    @GetMapping("/saved")
    public String saved() {
        return "saved"; // templates/saved.html
    }

    // -------------------------
    // PROFILE
    // -------------------------
    @GetMapping("/profile")
    public String profile() {
        return "profile"; // templates/profile.html
    }

    // -------------------------
    // LOGIN
    // -------------------------
    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html
    }

    // -------------------------
    // REGISTER
    // -------------------------
    @GetMapping("/register")
    public String register() {
        return "register"; // templates/register.html
    }

    // -------------------------
    // LOGOUT (redirect to login)
    // -------------------------
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    // -------------------------
    // FORGOT PASSWORD
    // -------------------------
    @GetMapping("/forgotPassword")
    public String forgotPassword() {return "forgotPassword";}
}