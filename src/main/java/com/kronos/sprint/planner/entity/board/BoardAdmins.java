package com.kronos.sprint.planner.entity.board;

import java.util.List;

public class BoardAdmins{
	private List<Object> groupKeys;
	private List<UserKeysItem> userKeys;

	public List<Object> getGroupKeys(){
		return groupKeys;
	}

	public List<UserKeysItem> getUserKeys(){
		return userKeys;
	}
}