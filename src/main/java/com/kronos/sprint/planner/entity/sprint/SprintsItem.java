package com.kronos.sprint.planner.entity.sprint;

public class SprintsItem{
	private int sequence;
	private int linkedPagesCount;
	private String goal;
	private String name;
	private int id;
	private String state;

	public int getSequence(){
		return sequence;
	}

	public int getLinkedPagesCount(){
		return linkedPagesCount;
	}

	public String getGoal(){
		return goal;
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
}
