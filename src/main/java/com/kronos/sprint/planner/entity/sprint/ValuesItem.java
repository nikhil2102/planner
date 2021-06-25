package com.kronos.sprint.planner.entity.sprint;

public class ValuesItem{
	private int originBoardId;
	private String goal;
	private String endDate;
	private String name;
	private String self;
	private int id;
	private String state;
	private String activatedDate;
	private String startDate;

	public int getOriginBoardId(){
		return originBoardId;
	}

	public String getGoal(){
		return goal;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getActivatedDate(){
		return activatedDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
