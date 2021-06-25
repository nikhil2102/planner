package com.kronos.sprint.planner.entity;

public class SprintCapacity {

    private int sprintId;
    private int storyPoint;
    private int capacity;

    public SprintCapacity(int sprintId, int storyPoint, int capacity) {
        this.sprintId = sprintId;
        this.storyPoint = storyPoint;
        this.capacity = capacity;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public int getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(int storyPoint) {
        this.storyPoint = storyPoint;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
