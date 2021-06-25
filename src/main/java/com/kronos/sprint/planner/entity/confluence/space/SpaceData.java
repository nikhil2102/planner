package com.kronos.sprint.planner.entity.confluence.space;

import java.util.List;

public class SpaceData{
	private int totalSize;
	private List<SpacesItem> spaces;

	public int getTotalSize(){
		return totalSize;
	}

	public List<SpacesItem> getSpaces(){
		return spaces;
	}
}