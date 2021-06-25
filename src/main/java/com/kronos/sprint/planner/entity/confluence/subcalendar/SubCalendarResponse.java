package com.kronos.sprint.planner.entity.confluence.subcalendar;

import java.util.List;

public class SubCalendarResponse{
	private List<PayloadItem> payload;
	private boolean success;

	public List<PayloadItem> getPayload(){
		return payload;
	}

	public boolean isSuccess(){
		return success;
	}
}