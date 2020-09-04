package com.kronos.sprint.planner.entity;

public class MembershipsItem{
	private String dateToANSI;
	private Role role;
	private int teamMemberId;
	private int teamId;
	private String dateTo;
	private int id;
	private String availability;
	private String dateFrom;
	private String dateFromANSI;
	private String status;

	public String getDateToANSI(){
		return dateToANSI;
	}

	public Role getRole(){
		return role;
	}

	public int getTeamMemberId(){
		return teamMemberId;
	}

	public int getTeamId(){
		return teamId;
	}

	public String getDateTo(){
		return dateTo;
	}

	public int getId(){
		return id;
	}

	public String getAvailability(){
		return availability;
	}

	public String getDateFrom(){
		return dateFrom;
	}

	public String getDateFromANSI(){
		return dateFromANSI;
	}

	public String getStatus(){
		return status;
	}
}
