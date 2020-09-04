package com.kronos.sprint.planner.entity.sprint;

import java.util.List;

public class Sprint{
	private List<Object> remoteLinks;
	private int daysRemaining;
	private int sequence;
	private int linkedPagesCount;
	private String goal;
	private String endDate;
	private String name;
	private int id;
	private String state;
	private boolean canUpdateSprint;
	private String startDate;
	private String completeDate;

	public List<Object> getRemoteLinks(){
		return remoteLinks;
	}

	public int getDaysRemaining(){
		return daysRemaining;
	}

	public int getSequence(){
		return sequence;
	}

	public int getLinkedPagesCount(){
		return linkedPagesCount;
	}

	public String getGoal(){
		return goal;
	}

	public String getEndDate(){
		return endDate;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getState(){
		return state;
	}

	public boolean isCanUpdateSprint(){
		return canUpdateSprint;
	}

	public String getStartDate(){
		return startDate;
	}

	public String getCompleteDate(){
		return completeDate;
	}
}