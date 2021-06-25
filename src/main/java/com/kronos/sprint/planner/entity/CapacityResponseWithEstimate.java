package com.kronos.sprint.planner.entity;

import com.kronos.sprint.planner.entity.capacity.CapacityResponse;

public class CapacityResponseWithEstimate {

    private CapacityResponse capacityResponse;
    private long estimatedEffort;
    private long spentEffort;
    private long remainingEffort;

    public CapacityResponseWithEstimate() {
    }

    public CapacityResponseWithEstimate(CapacityResponse capacityResponse, long estimatedEffort, long spentEffort, long remainingEffort) {
        this.capacityResponse = capacityResponse;
        this.estimatedEffort = estimatedEffort;
        this.spentEffort = spentEffort;
        this.remainingEffort = remainingEffort;
    }

    public CapacityResponse getCapacityResponse() {
        return capacityResponse;
    }

    public void setCapacityResponse(CapacityResponse capacityResponse) {
        this.capacityResponse = capacityResponse;
    }

    public long getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(int estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public long getSpentEffort() {
        return spentEffort;
    }

    public void setSpentEffort(int spentEffort) {
        this.spentEffort = spentEffort;
    }

    public long getRemainingEffort() {
        return remainingEffort;
    }

    public void setRemainingEffort(int remainingEffort) {
        this.remainingEffort = remainingEffort;
    }

    @Override
    public String toString() {
        return "CapacityResponseWithEstimate{" +
                "capacityResponse=" + capacityResponse +
                ", estimatedEffort='" + estimatedEffort + '\'' +
                ", spentEffort='" + spentEffort + '\'' +
                ", remainingEffort='" + remainingEffort + '\'' +
                '}';
    }
}
