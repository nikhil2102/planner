package com.kronos.sprint.planner.entity.capacity;

public class Timetracking{
	private int originalEstimateSeconds;
	private String remainingEstimate;
	private int remainingEstimateSeconds;
	private String originalEstimate;
	private int timeSpentSeconds;
	private String timeSpent;

	public int getOriginalEstimateSeconds(){
		return originalEstimateSeconds;
	}

	public String getRemainingEstimate(){
		return remainingEstimate;
	}

	public int getRemainingEstimateSeconds(){
		return remainingEstimateSeconds;
	}

	public String getOriginalEstimate(){
		return originalEstimate;
	}

	public int getTimeSpentSeconds(){
		return timeSpentSeconds;
	}

	public String getTimeSpent(){
		return timeSpent;
	}
}
