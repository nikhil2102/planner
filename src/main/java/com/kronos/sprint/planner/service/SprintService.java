package com.kronos.sprint.planner.service;

import com.kronos.sprint.planner.entity.Sprint;

import java.util.List;

public interface SprintService {

    List<Sprint> getAllSprints();

    Sprint getSprintById(int id);

    List<Sprint> getSprintByTeam(String team);

    List<Sprint> getSprintsBySprintName(String sprintName);

    List<Sprint> saveSprint(Sprint sprint);

    List<Sprint> updateSprint(Sprint sprint);

    List<Sprint> deleteSprint(int sprint);

    boolean deleteAllSprints();
}
