package com.kronos.sprint.planner.repository;

import com.kronos.sprint.planner.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}
