package com.kronos.sprint.planner.entity;

import com.kronos.sprint.planner.entity.sprint.JiraSprintDetail;

public class ResourceData {

    private JiraResponse jiraTeamResourceDataJiraResponse;
    private JiraSprintDetail jiraSprintDetail;

    public ResourceData(JiraResponse jiraTeamResourceDataJiraResponse, JiraSprintDetail jiraSprintDetail) {
        this.jiraTeamResourceDataJiraResponse = jiraTeamResourceDataJiraResponse;
        this.jiraSprintDetail = jiraSprintDetail;
    }

    public JiraResponse getJiraTeamResourceDataJiraResponse() {
        return jiraTeamResourceDataJiraResponse;
    }

    public void setJiraTeamResourceDataJiraResponse(JiraResponse jiraTeamResourceDataJiraResponse) {
        this.jiraTeamResourceDataJiraResponse = jiraTeamResourceDataJiraResponse;
    }

    public JiraSprintDetail getJiraSprintDetail() {
        return jiraSprintDetail;
    }

    public void setJiraSprintDetail(JiraSprintDetail jiraSprintDetail) {
        this.jiraSprintDetail = jiraSprintDetail;
    }

    @Override
    public String toString() {
        return "ResourceData{" +
                "jiraTeamResourceDataJiraResponse=" + jiraTeamResourceDataJiraResponse +
                ", jiraSprintDetail=" + jiraSprintDetail +
                '}';
    }
}
