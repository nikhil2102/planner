package com.kronos.sprint.planner.entity.sprint;

public class SprintDetail{
	private String userWhoStarted;
	private boolean supportsPages;
	private Contents contents;
	private Sprint sprint;
	private String lastUserToClose;
	private SprintCapacity sprintCapacity;

	public String getUserWhoStarted(){
		return userWhoStarted;
	}

	public boolean isSupportsPages(){
		return supportsPages;
	}

	public Contents getContents(){
		return contents;
	}

	public Sprint getSprint(){
		return sprint;
	}

	public String getLastUserToClose(){
		return lastUserToClose;
	}

	public SprintCapacity getSprintCapacity() {
		return sprintCapacity;
	}

	public void setSprintCapacity(SprintCapacity sprintCapacity) {
		this.sprintCapacity = sprintCapacity;
	}
}
