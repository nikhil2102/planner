package com.kronos.sprint.planner.entity.capacity;

public class Assignee{
	private String emailAddress;
	private AvatarUrls avatarUrls;
	private String displayName;
	private String name;
	private String self;
	private boolean active;
	private String timeZone;
	private String key;

	public String getEmailAddress(){
		return emailAddress;
	}

	public AvatarUrls getAvatarUrls(){
		return avatarUrls;
	}

	public String getDisplayName(){
		return displayName;
	}

	public String getName(){
		return name;
	}

	public String getSelf(){
		return self;
	}

	public boolean isActive(){
		return active;
	}

	public String getTimeZone(){
		return timeZone;
	}

	public String getKey(){
		return key;
	}
}
