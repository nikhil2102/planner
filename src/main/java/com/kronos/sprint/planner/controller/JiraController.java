package com.kronos.sprint.planner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiraController {

    @GetMapping("/kronosteams")
    public String getTeams() {
        return null;
    }
}
