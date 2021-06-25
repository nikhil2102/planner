package com.kronos.sprint.planner.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class KronosTimeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int KronosTimeTrackingId;
    private String remainingEstimate;
    private String originalEstimate;
    private String timeSpent;
    @OneToOne(fetch = FetchType.LAZY)
    private ResourceIssue resourceIssue;

    public KronosTimeTracking(String remainingEstimate, String originalEstimate,
                              String timeSpent) {
        this.remainingEstimate = remainingEstimate;
        this.originalEstimate = originalEstimate;
        this.timeSpent = timeSpent;
    }

    public KronosTimeTracking() {
    }

    public int getKronosTimeTrackingId() {
        return KronosTimeTrackingId;
    }

    public void setKronosTimeTrackingId(int kronosTimeTrackingId) {
        KronosTimeTrackingId = kronosTimeTrackingId;
    }

    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public String getOriginalEstimate() {
        return originalEstimate;
    }

    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public ResourceIssue getResourceIssue() {
        return resourceIssue;
    }

    public void setResourceIssue(ResourceIssue resourceIssue) {
        this.resourceIssue = resourceIssue;
    }

    @Override
    public String toString() {
        return "KronosTimeTracking{" +
                "KronosTimeTrackingId=" + KronosTimeTrackingId +
                ", remainingEstimate='" + remainingEstimate + '\'' +
                ", originalEstimate='" + originalEstimate + '\'' +
                ", timeSpent='" + timeSpent + '\'' +
                ", resourceIssue=" + resourceIssue +
                '}';
    }
}
