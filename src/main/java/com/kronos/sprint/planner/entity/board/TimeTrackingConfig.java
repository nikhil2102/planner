package com.kronos.sprint.planner.entity.board;

public class TimeTrackingConfig{
	private int daysPerWeek;
	private Symbols symbols;
	private int hoursPerDay;

	public int getDaysPerWeek(){
		return daysPerWeek;
	}

	public Symbols getSymbols(){
		return symbols;
	}

	public int getHoursPerDay(){
		return hoursPerDay;
	}
}
