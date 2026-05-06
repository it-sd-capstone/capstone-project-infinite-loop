package com.happenings.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {
    @GetMapping("/api/debug/profile")
    public String profile(@Value("${spring.profiles.active:default}") String profile) {
        return profile;
    }
}
