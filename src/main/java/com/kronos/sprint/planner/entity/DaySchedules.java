package com.kronos.sprint.planner.entity;

import java.util.List;

public class DaySchedules{
	private List<JsonMember11Item> jsonMember11;
	private List<JsonMember21Item> jsonMember21;
	private List<JsonMember61Item> jsonMember61;

	public List<JsonMember11Item> getJsonMember11(){
		return jsonMember11;
	}

	public List<JsonMember21Item> getJsonMember21(){
		return jsonMember21;
	}

	public List<JsonMember61Item> getJsonMember61(){
		return jsonMember61;
	}
}