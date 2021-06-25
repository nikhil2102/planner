package com.kronos.sprint.planner.entity.sprint;

import java.util.List;

public class JiraSprintDetail{
	private boolean isLast;
	private int maxResults;
	private List<ValuesItem> values;
	private int startAt;

	public boolean isIsLast(){
		return isLast;
	}

	public int getMaxResults(){
		return maxResults;
	}

	public List<ValuesItem> getValues(){
		return values;
	}

	public int getStartAt(){
		return startAt;
	}
}