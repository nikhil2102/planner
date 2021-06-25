package com.kronos.sprint.planner.entity.board;

import java.util.List;

public class AllBoards{
	private int total;
	private GlobalConfig globalConfig;
	private List<ViewsItem> views;
	private int startAt;

	public int getTotal(){
		return total;
	}

	public GlobalConfig getGlobalConfig(){
		return globalConfig;
	}

	public List<ViewsItem> getViews(){
		return views;
	}

	public int getStartAt(){
		return startAt;
	}
}