package com.kronos.sprint.planner.entity;

public class JiraTeamData {

    private int id;
    private String name;
    private String mission;
    private String summary;
    private String lead;

    public JiraTeamData() {
    }

    public JiraTeamData(int id, String name, String mission, String summary, String lead) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.summary = summary;
        this.lead = lead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    @Override
    public String toString() {
        return "JiraResource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mission='" + mission + '\'' +
                ", summary='" + summary + '\'' +
                ", lead='" + lead + '\'' +
                '}';
    }
}
