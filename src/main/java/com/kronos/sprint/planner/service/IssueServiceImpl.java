package com.kronos.sprint.planner.service;

import com.kronos.sprint.planner.entity.ResourceIssue;
import com.kronos.sprint.planner.entity.capacity.CapacityResponse;
import com.kronos.sprint.planner.entity.capacity.IssuesItem;
import com.kronos.sprint.planner.entity.capacity.Timetracking;
import com.kronos.sprint.planner.proxy.JiraServiceProxy;
import com.kronos.sprint.planner.utility.PlannerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private JiraServiceProxy jiraServiceProxy;

    @Override
    public Map<String, List<ResourceIssue>> getResources(int sprintId) {

        CapacityResponse capacityResponse = jiraServiceProxy.retrieveAllIssues("Sprint=" + sprintId,
                0, 100, "labels,issuelinks,duedate,issuetype,summary,assignee," +
                        "timetracking,parent,status");

        Map<String, List<ResourceIssue>> resourceMap = new HashMap<>();
        List<IssuesItem> issuesItems = capacityResponse.getIssues();

        if (!issuesItems.isEmpty()) {

            for (IssuesItem issuesItem : issuesItems) {
                String assigneeName = PlannerUtility.getAssigneeName(issuesItem);
                Timetracking timetracking = issuesItem.getFields().getTimetracking();
                String summary = issuesItem.getFields().getSummary();
                String type = issuesItem.getFields().getIssuetype().getName();
                String status = issuesItem.getFields().getStatus().getStatusCategory().getName();
                String issueKey = issuesItem.getKey();
                ResourceIssue newResourceIssue = new ResourceIssue(issueKey, timetracking, summary, type, status);

                if (resourceMap.get(assigneeName) != null) {
                    ArrayList<ResourceIssue> resourceList = new ArrayList<>();
                    resourceList.addAll(resourceMap.get(assigneeName));
                    resourceList.add(newResourceIssue);
                    resourceMap.put(assigneeName, resourceList);
                } else {
                    resourceMap.put(assigneeName, Arrays.asList(newResourceIssue));
                }
            }
        }
        return resourceMap;
    }
}
