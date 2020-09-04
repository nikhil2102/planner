package com.kronos.sprint.planner.entity.sprint;

import java.util.List;

public class SprintResponse {
	private int rapidViewId;
	private List<SprintsItem> sprints;

	public int getRapidViewId(){
		return rapidViewId;
	}

	public List<SprintsItem> getSprints(){
		return sprints;
	}
}