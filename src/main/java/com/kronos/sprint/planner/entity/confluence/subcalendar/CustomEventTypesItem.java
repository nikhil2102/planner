package com.kronos.sprint.planner.entity.confluence.subcalendar;

public class CustomEventTypesItem{
	private String created;
	private String icon;
	private int periodInMins;
	private String customEventTypeId;
	private String title;
	private String parentSubCalendarId;

	public String getCreated(){
		return created;
	}

	public String getIcon(){
		return icon;
	}

	public int getPeriodInMins(){
		return periodInMins;
	}

	public String getCustomEventTypeId(){
		return customEventTypeId;
	}

	public String getTitle(){
		return title;
	}

	public String getParentSubCalendarId(){
		return parentSubCalendarId;
	}
}
