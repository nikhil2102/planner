package com.kronos.sprint.planner.repository;

import com.kronos.sprint.planner.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {

    List<Sprint> findByTeamIsOrderBySprintName(String team);

    List<Sprint> findBySprintNameOrderBySprintName(String sprintName);

}
