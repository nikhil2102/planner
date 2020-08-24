package com.kronos.sprint.planner.repository;

import com.kronos.sprint.planner.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    List<Resource> findResourcesByTeamOrderByName(String teamName);

    List<Resource> findResourcesByTypeOrderByName(String type);
}
