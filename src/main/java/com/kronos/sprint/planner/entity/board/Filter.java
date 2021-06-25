package com.kronos.sprint.planner.entity.board;

import java.util.List;

public class Filter{
	private Owner owner;
	private List<PermissionEntriesItem> permissionEntries;
	private String query;
	private boolean canEdit;
	private String name;
	private int id;
	private boolean isOrderedByRank;
	private boolean canBeFixed;

	public Owner getOwner(){
		return owner;
	}

	public List<PermissionEntriesItem> getPermissionEntries(){
		return permissionEntries;
	}

	public String getQuery(){
		return query;
	}

	public boolean isCanEdit(){
		return canEdit;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public boolean isIsOrderedByRank(){
		return isOrderedByRank;
	}

	public boolean isCanBeFixed(){
		return canBeFixed;
	}
}