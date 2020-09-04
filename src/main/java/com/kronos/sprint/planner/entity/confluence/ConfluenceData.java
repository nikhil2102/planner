package com.kronos.sprint.planner.entity.confluence;

import java.util.List;

public class ConfluenceData{
	private boolean success;
	private List<EventsItem> events;

	public boolean isSuccess(){
		return success;
	}

	public List<EventsItem> getEvents(){
		return events;
	}
}