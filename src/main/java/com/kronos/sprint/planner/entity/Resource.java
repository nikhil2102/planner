package com.kronos.sprint.planner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Resource",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"name", "team"}))
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourceId;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotNull
    private int absentDays;
    @NotBlank
    private String team;
    @NotBlank
    private int availability;
    @OneToMany(mappedBy = "resource")
    private List<ResourceIssue> issuesList;

    public Resource() {
    }

    public Resource(String name, String type, int absentDays, String team) {
        this.name = name;
        this.type = type;
        this.absentDays = absentDays;
        this.team = team;
    }

    public Resource(String name, List<ResourceIssue> issuesList) {
        this.name = name;
        this.issuesList = issuesList;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(int absentDays) {
        this.absentDays = absentDays;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public List<ResourceIssue> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(List<ResourceIssue> issuesList) {
        this.issuesList = issuesList;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", absentDays=" + absentDays +
                ", team='" + team + '\'' +
                ", availability=" + availability +
                ", issuesList=" + issuesList +
                '}';
    }
}
