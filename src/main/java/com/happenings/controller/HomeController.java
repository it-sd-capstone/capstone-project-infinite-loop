package com.happenings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    // -------------------------
    // API HEALTH CHECK
    // -------------------------
    @GetMapping("/health")
    public String health() {
        return "Happenings API is running!";
    }
}