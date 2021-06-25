package com.kronos.sprint.planner.entity;

import java.util.List;

public class TeamMembersItem{
	private int holidaySchemeId;
	private List<ConflictingMembershipsItem> conflictingMemberships;
	private String displayname;
	private String name;
	private Avatar avatar;
	private boolean jiraUser;
	private String key;
	private List<MembershipsItem> memberships;
	private int workloadSchemeId;
	private long estimatedEffortHours;

	public int getHolidaySchemeId(){
		return holidaySchemeId;
	}

	public List<ConflictingMembershipsItem> getConflictingMemberships(){
		return conflictingMemberships;
	}

	public String getDisplayname(){
		return displayname;
	}

	public String getName(){
		return name;
	}

	public Avatar getAvatar(){
		return avatar;
	}

	public boolean isJiraUser(){
		return jiraUser;
	}

	public String getKey(){
		return key;
	}

	public List<MembershipsItem> getMemberships(){
		return memberships;
	}

	public int getWorkloadSchemeId(){
		return workloadSchemeId;
	}

	public long getEstimatedEffortHours() {
		return estimatedEffortHours;
	}

	public void setEstimatedEffortHours(long estimatedEffortHours) {
		this.estimatedEffortHours = estimatedEffortHours;
	}
}