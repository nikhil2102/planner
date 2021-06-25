package com.kronos.sprint.planner.entity.capacity;

public class Status{
	private String name;
	private String self;
	private String description;
	private String iconUrl;
	private String id;
	private StatusCategory statusCategory;

	public String getName(){
		return name;
	}

	public String getSelf(){
		return self;
	}

	public String getDescription(){
		return description;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public String getId(){
		return id;
	}

	public StatusCategory getStatusCategory(){
		return statusCategory;
	}
}
