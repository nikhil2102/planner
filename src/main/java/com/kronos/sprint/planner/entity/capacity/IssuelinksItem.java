package com.kronos.sprint.planner.entity.capacity;

public class IssuelinksItem{
	private OutwardIssue outwardIssue;
	private String self;
	private String id;
	private Type type;

	public OutwardIssue getOutwardIssue(){
		return outwardIssue;
	}

	public String getSelf(){
		return self;
	}

	public String getId(){
		return id;
	}

	public Type getType(){
		return type;
	}
}
