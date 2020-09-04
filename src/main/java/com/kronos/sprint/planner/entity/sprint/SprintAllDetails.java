package com.kronos.sprint.planner.entity.sprint;

public class SprintAllDetails {

    SprintsItem sprintsItem;
    SprintSummary sprintSummary;
    SprintDetail sprintDetail;

    public SprintAllDetails(SprintsItem sprintsItem, SprintSummary sprintSummary, SprintDetail sprintDetail) {
        this.sprintsItem = sprintsItem;
        this.sprintSummary = sprintSummary;
        this.sprintDetail = sprintDetail;
    }

    public SprintAllDetails() {
    }

    public SprintsItem getSprintsItem() {
        return sprintsItem;
    }

    public void setSprintsItem(SprintsItem sprintsItem) {
        this.sprintsItem = sprintsItem;
    }

    public SprintSummary getSprintSummary() {
        return sprintSummary;
    }

    public void setSprintSummary(SprintSummary sprintSummary) {
        this.sprintSummary = sprintSummary;
    }

    public SprintDetail getSprintDetail() {
        return sprintDetail;
    }

    public void setSprintDetail(SprintDetail sprintDetail) {
        this.sprintDetail = sprintDetail;
    }

    @Override
    public String toString() {
        return "SprintAllDetails{" +
                "sprintsItem=" + sprintsItem +
                ", sprintSummary=" + sprintSummary +
                ", sprintDetail=" + sprintDetail +
                '}';
    }
}
