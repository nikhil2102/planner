package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.entity.CapacityResponseWithEstimate;
import com.kronos.sprint.planner.entity.ResourceIssue;
import com.kronos.sprint.planner.entity.capacity.CapacityResponse;
import com.kronos.sprint.planner.entity.capacity.IssuesItem;
import com.kronos.sprint.planner.proxy.JiraServiceProxy;
import com.kronos.sprint.planner.service.IssueServiceImpl;
import com.kronos.sprint.planner.utility.PlannerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class IssueController {

    @Autowired
    JiraServiceProxy jiraServiceProxy;
    @Autowired
    IssueServiceImpl issueService;

    @GetMapping("/allissues/{sprintId}")
    public CapacityResponseWithEstimate getAllIssues(@PathVariable int sprintId) {

        CapacityResponseWithEstimate capacityResponseWithEstimate = new CapacityResponseWithEstimate();
        if (sprintId != 0) {
            CapacityResponse capacityResponse = jiraServiceProxy.retrieveAllIssues("Sprint=" + sprintId,
                    0, 100, "labels,issuelinks,duedate,issuetype,summary,assignee," +
                            "timetracking,parent,status");

            int cumulativeOriginalEsimatedSeconds = 0;
            int cumulativeTimeSpentSeconds = 0;
            int cumulativeRemainingSeconds = 0;

            if (capacityResponse != null) {
                for (IssuesItem issuesItem : capacityResponse.getIssues()) {
                    int originalEsimatedSeconds = issuesItem.getFields() != null ? issuesItem.getFields().getTimetracking().getOriginalEstimateSeconds() : 0;
                    cumulativeOriginalEsimatedSeconds = cumulativeOriginalEsimatedSeconds + originalEsimatedSeconds;
                    int timeSpendSeconds = issuesItem.getFields() != null ? issuesItem.getFields().getTimetracking().getTimeSpentSeconds() : 0;
                    cumulativeTimeSpentSeconds = cumulativeTimeSpentSeconds + timeSpendSeconds;
                    int remainingEstimateSeconds = issuesItem.getFields() != null ? issuesItem.getFields().getTimetracking().getRemainingEstimateSeconds() : 0;
                    cumulativeRemainingSeconds = cumulativeRemainingSeconds + remainingEstimateSeconds;
                }
            }
            PlannerUtility.calculateTime(cumulativeOriginalEsimatedSeconds);
            PlannerUtility.calculateTime(cumulativeTimeSpentSeconds);
            PlannerUtility.calculateTime(cumulativeRemainingSeconds);

            capacityResponseWithEstimate = new CapacityResponseWithEstimate(capacityResponse,
                    TimeUnit.SECONDS.toHours(cumulativeOriginalEsimatedSeconds),
                    TimeUnit.SECONDS.toHours(cumulativeTimeSpentSeconds),
                    TimeUnit.SECONDS.toHours(cumulativeRemainingSeconds));
        }
        else {
            capacityResponseWithEstimate = new CapacityResponseWithEstimate();
        }
        return capacityResponseWithEstimate;
    }

    @GetMapping("/allteamissues/{sprintId}")
    public Map<String, List<ResourceIssue>> getAllIssuesNew(@PathVariable int sprintId) {

        Map<String, List<ResourceIssue>> resourceMap = new HashMap<>();
        if (sprintId != 0) {
            resourceMap = issueService.getResources(sprintId);
        } else {
        }
        return resourceMap;
    }

    @GetMapping("/allissues/{sprintId}/{assignee}")
    public CapacityResponse getIssuesByAssignee(@PathVariable int sprintId, @PathVariable String assignee) {

        CapacityResponse capacityResponse = jiraServiceProxy.retrieveIssuesByAssignee(
                "Sprint=" + sprintId + "&assignee=" + assignee,
                0, 50, "issuetype,summary,assigne,status,timetracking,issuelinks,subtasks");
        return capacityResponse;
    }
}
