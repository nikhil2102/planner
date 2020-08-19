package com.kronos.sprint.planner.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sprintId;

    @NotNull
    @NotBlank
    private String sprintName;

    @NotBlank
    @Size (max = 20)
    private String team;

    @NotNull
    @NotBlank
    private String sprintStartDate;

    @NotNull
    @NotBlank
    private String sprintEndDate;

    @NotNull
    private int storyPoint;

    public Sprint() {
    }

    public Sprint(String sprintName, String team, String sprintStartDate, String sprintEndDate, int storyPoint) {
        this.sprintName = sprintName;
        this.team = team;
        this.sprintStartDate = sprintStartDate;
        this.sprintEndDate = sprintEndDate;
        this.storyPoint = storyPoint;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getSprintStartDate() {
        return sprintStartDate;
    }

    public void setSprintStartDate(String sprintStartDate) {
        this.sprintStartDate = sprintStartDate;
    }

    public String getSprintEndDate() {
        return sprintEndDate;
    }

    public void setSprintEndDate(String sprintEndDate) {
        this.sprintEndDate = sprintEndDate;
    }

    public int getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(int storyPoint) {
        this.storyPoint = storyPoint;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "sprintId=" + sprintId +
                ", sprintName='" + sprintName + '\'' +
                ", team='" + team + '\'' +
                ", sprintStartDate='" + sprintStartDate + '\'' +
                ", sprintEndDate='" + sprintEndDate + '\'' +
                ", storyPoint=" + storyPoint +
                '}';
    }
}
