package com.kronos.sprint.planner.service;

import com.kronos.sprint.planner.entity.ResourceIssue;

import java.util.List;
import java.util.Map;

public interface IssueService {

    Map<String, List<ResourceIssue>> getResources(int sprintId);
}
