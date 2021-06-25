package com.kronos.sprint.planner.entity.confluence.subcalendar;

public class SanboxEventTypeRemindersItem{
	private String eventTypeId;
	private int periodInMins;
	private boolean isCustomEventType;

	public String getEventTypeId(){
		return eventTypeId;
	}

	public int getPeriodInMins(){
		return periodInMins;
	}

	public boolean isIsCustomEventType(){
		return isCustomEventType;
	}
}
