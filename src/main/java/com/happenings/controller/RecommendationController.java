package com.happenings.controller;

import com.happenings.entity.Event;
import com.happenings.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "*")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Event>> getRecommendations(
            @PathVariable Integer userId
    ) {

        List<Event> recommendations =
                recommendationService.getRecommendations(userId);

        return ResponseEntity.ok(recommendations);
    }
}