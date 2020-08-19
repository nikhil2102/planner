package com.kronos.sprint.planner.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Resource {

    @Id
    private int resourceId;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotNull
    private int absentDays;
    @NotBlank
    private String team;

    public Resource() {
    }

    public Resource(String name, String type, int absentDays, String team) {
        this.name = name;
        this.type = type;
        this.absentDays = absentDays;
        this.team = team;
    }

    public int getId() {
        return resourceId;
    }

    public void setId(int resourceId) {
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

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", absentDays=" + absentDays +
                ", team=" + team +
                '}';
    }
}
