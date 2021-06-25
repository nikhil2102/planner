package com.kronos.sprint.planner.entity.capacity;

public class Issuetype{
	private int avatarId;
	private String name;
	private String self;
	private String description;
	private String id;
	private String iconUrl;
	private boolean subtask;

	public int getAvatarId(){
		return avatarId;
	}

	public String getName(){
		return name;
	}

	public String getSelf(){
		return self;
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

	public boolean isSubtask(){
		return subtask;
	}
}
