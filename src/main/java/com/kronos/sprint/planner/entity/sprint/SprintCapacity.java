package com.kronos.sprint.planner.entity.sprint;

public class SprintCapacity {

    private int numberOfLeaves;
    private int capacity;

    public SprintCapacity(int numberOfLeaves, int capacity) {
        this.numberOfLeaves = numberOfLeaves;
        this.capacity = capacity;
    }

    public int getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public void setNumberOfLeaves(int numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
