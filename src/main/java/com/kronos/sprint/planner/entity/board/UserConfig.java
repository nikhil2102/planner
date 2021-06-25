package com.kronos.sprint.planner.entity.board;

public class UserConfig{
	private boolean canCreateProject;
	private String avatarUrl;
	private String displayName;
	private boolean hasFiltersAccessible;
	private boolean canCreateBoard;
	private String name;
	private boolean canCreateIssue;
	private boolean isGlobalAdmin;
	private boolean hasProjectsAccessible;

	public boolean isCanCreateProject(){
		return canCreateProject;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public String getDisplayName(){
		return displayName;
	}

	public boolean isHasFiltersAccessible(){
		return hasFiltersAccessible;
	}

	public boolean isCanCreateBoard(){
		return canCreateBoard;
	}

	public String getName(){
		return name;
	}

	public boolean isCanCreateIssue(){
		return canCreateIssue;
	}

	public boolean isIsGlobalAdmin(){
		return isGlobalAdmin;
	}

	public boolean isHasProjectsAccessible(){
		return hasProjectsAccessible;
	}
}
