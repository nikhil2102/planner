package com.kronos.sprint.planner.entity.sprint;

public class Status{
	private String name;
	private String description;
	private String id;
	private String iconUrl;
	private StatusCategory statusCategory;

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public String getId(){
		return id;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public StatusCategory getStatusCategory(){
		return statusCategory;
	}
}
