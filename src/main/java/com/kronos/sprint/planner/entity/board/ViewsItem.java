package com.kronos.sprint.planner.entity.board;

public class ViewsItem{
	private Filter filter;
	private boolean sprintSupportEnabled;
	private boolean canEdit;
	private String name;
	private int id;
	private BoardAdmins boardAdmins;

	public Filter getFilter(){
		return filter;
	}

	public boolean isSprintSupportEnabled(){
		return sprintSupportEnabled;
	}

	public boolean isCanEdit(){
		return canEdit;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public BoardAdmins getBoardAdmins(){
		return boardAdmins;
	}
}
