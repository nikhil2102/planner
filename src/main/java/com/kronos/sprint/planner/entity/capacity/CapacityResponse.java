package com.kronos.sprint.planner.entity.capacity;

import java.util.List;

public class CapacityResponse {
    private String expand;
    private int total;
    private int maxResults;
    private List<IssuesItem> issues;
    private int startAt;

    public CapacityResponse() {
    }

    public CapacityResponse(String expand) {
        this.expand = expand;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public int getTotal() {
        return total;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public List<IssuesItem> getIssues() {
        return issues;
    }

    public int getStartAt() {
        return startAt;
    }
}