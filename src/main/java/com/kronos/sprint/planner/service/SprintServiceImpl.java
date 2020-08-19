package com.kronos.sprint.planner.service;

import com.kronos.sprint.planner.entity.Sprint;
import com.kronos.sprint.planner.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    SprintRepository sprintRepository;

    @Override
    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public Sprint getSprintById(int id) {
        return sprintRepository.findById(id).get();
    }

    @Override
    public List<Sprint> getSprintByTeam(String team) {
        return sprintRepository.findByTeamIsOrderBySprintName(team);
    }

    @Override
    public List<Sprint> getSprintsBySprintName(String sprintName) {
        return sprintRepository.findBySprintNameOrderBySprintName(sprintName);
    }

    @Override
    public List<Sprint> saveSprint(Sprint sprint) {
        sprintRepository.save(sprint);
        return getAllSprints();
    }

    @Override
    public List<Sprint> updateSprint(Sprint sprint) {
        sprintRepository.save(sprint);
        return getAllSprints();
    }

    @Override
    public List<Sprint> deleteSprint(int sprintId) {
        sprintRepository.deleteById(sprintId);
        return getAllSprints();
    }

    @Override
    public boolean deleteAllSprints() {
        sprintRepository.deleteAll();
        return sprintRepository.count() == 0L;
    }

}
