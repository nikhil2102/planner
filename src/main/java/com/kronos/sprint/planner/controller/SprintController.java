package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.entity.Sprint;
import com.kronos.sprint.planner.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SprintController {

    @Autowired
    SprintService sprintService;

    @GetMapping("/sprints")
    public List<Sprint> retrieveAllSprints() {
        return sprintService.getAllSprints();
    }

    @GetMapping("/sprints-by-team/{teamName}")
    public List<Sprint> retrieveAllSprintsByTeamName(@PathVariable String teamName) {
        return sprintService.getSprintByTeam(teamName);
    }

    @GetMapping("/sprints-by-name/{sprintName}")
    public List<Sprint> retrieveAllSprintsBySprintName(@PathVariable String sprintName) {
        return sprintService.getSprintsBySprintName(sprintName);
    }

    @PostMapping("/sprint")
    public List<Sprint> saveSprint(@Valid @RequestBody Sprint sprint) {
        return sprintService.saveSprint(sprint);
    }

    @PutMapping("/sprint")
    public List<Sprint> updateSprint(@RequestBody Sprint sprint) {
        return sprintService.updateSprint(sprint);
    }

    @DeleteMapping("/sprint/{sprintId}")
    public List<Sprint> deleteSprint(@PathVariable int sprintId) {
        return sprintService.deleteSprint(sprintId);
    }
/*
    @DeleteMapping("/delete-all-sprints")
    public boolean deleteAllSprints() {
        return sprintService.deleteAllSprints();
    }*/

/*   @GetMapping("/sprints/{spintId}")
    public Sprint retrieveSingleSprint(@PathVariable int sprintId) {
        return sprintService.getSprintById(sprintId);
    }*/
}
