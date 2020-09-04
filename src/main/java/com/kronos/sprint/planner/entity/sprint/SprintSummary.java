package com.kronos.sprint.planner.entity.sprint;

public class SprintSummary {
	private int originBoardId;
	private String goal;
	private String endDate;
	private String name;
	private String self;
	private int id;
	private String state;
	private String startDate;
	private String completeDate;

	public int getOriginBoardId(){
		return originBoardId;
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

	public String getSelf(){
		return self;
	}

	public int getId(){
		return id;
	}

	public String getState(){
		return state;
	}

	public String getStartDate(){
		return startDate;
	}

	public String getCompleteDate(){
		return completeDate;
	}
}
