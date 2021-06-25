package com.kronos.sprint.planner.entity;

import com.kronos.sprint.planner.entity.capacity.Timetracking;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ResourceIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourceIssuesId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Resource resource;
    private String issueKey;
    private String summary;
    private String type;
    private String status;
    @OneToOne(mappedBy = "resourceIssue")
    private KronosTimeTracking kronosTimeTracking;

    public ResourceIssue(String issueKey, Timetracking kronosTimeTracking, String summary, String type, String status) {
        this.issueKey = issueKey;
        KronosTimeTracking kronosTimeTracking1 = new KronosTimeTracking(kronosTimeTracking.getRemainingEstimate(),
                kronosTimeTracking.getOriginalEstimate(), kronosTimeTracking.getTimeSpent());
        this.kronosTimeTracking = kronosTimeTracking1;
        this.summary = summary;
        this.type = type;
        this.status = status;
    }

    public ResourceIssue() {
    }

    public int getResourceIssuesId() {
        return resourceIssuesId;
    }

    public void setResourceIssuesId(int resourceIssuesId) {
        this.resourceIssuesId = resourceIssuesId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public KronosTimeTracking getKronosTimeTracking() {
        return kronosTimeTracking;
    }

    public void setKronosTimeTracking(KronosTimeTracking kronosTimeTracking) {
        this.kronosTimeTracking = kronosTimeTracking;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResourceIssue{" +
                "resourceIssuesId=" + resourceIssuesId +
                ", resource=" + resource +
                ", issueKey='" + issueKey + '\'' +
                ", summary='" + summary + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", kronosTimeTracking=" + kronosTimeTracking +
                '}';
    }
}
