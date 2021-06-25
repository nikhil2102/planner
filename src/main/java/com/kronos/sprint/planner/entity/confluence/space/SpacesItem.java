package com.kronos.sprint.planner.entity.confluence.space;

import java.util.List;

public class SpacesItem{
	private LastModifiedDate lastModifiedDate;
	private List<LinkItem> link;
	private String description;
	private String title;
	private boolean favourite;
	private Labels labels;
	private String summaryPath;
	private CreatedDate createdDate;
	private String effectiveUser;
	private String wikiLink;
	private String name;
	private Logo logo;
	private String key;

	public LastModifiedDate getLastModifiedDate(){
		return lastModifiedDate;
	}

	public List<LinkItem> getLink(){
		return link;
	}

	public String getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	public boolean isFavourite(){
		return favourite;
	}

	public Labels getLabels(){
		return labels;
	}

	public String getSummaryPath(){
		return summaryPath;
	}

	public CreatedDate getCreatedDate(){
		return createdDate;
	}

	public String getEffectiveUser(){
		return effectiveUser;
	}

	public String getWikiLink(){
		return wikiLink;
	}

	public String getName(){
		return name;
	}

	public Logo getLogo(){
		return logo;
	}

	public String getKey(){
		return key;
	}
}