package com.kronos.sprint.planner.entity;

import java.util.List;

public class JiraResponse {
    private DaySchedules daySchedules;
    private List<TeamMembersItem> teamMembers;

    public DaySchedules getDaySchedules() {
        return daySchedules;
    }

    public List<TeamMembersItem> getTeamMembers() {
        return teamMembers;
    }
}