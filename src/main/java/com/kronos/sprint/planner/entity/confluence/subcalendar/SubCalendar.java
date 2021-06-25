package com.kronos.sprint.planner.entity.confluence.subcalendar;

import java.util.List;

public class SubCalendar{
	private String creator;
	private boolean watchable;
	private String typeKey;
	private String color;
	private String timeZoneId;
	private String description;
	private boolean eventInviteesSupported;
	private String type;
	private List<CustomEventTypesItem> customEventTypes;
	private String parentId;
	private String spaceKey;
	private String spaceName;
	private String name;
	private String id;
	private boolean restrictable;

	public String getCreator(){
		return creator;
	}

	public boolean isWatchable(){
		return watchable;
	}

	public String getTypeKey(){
		return typeKey;
	}

	public String getColor(){
		return color;
	}

	public String getTimeZoneId(){
		return timeZoneId;
	}

	public String getDescription(){
		return description;
	}

	public boolean isEventInviteesSupported(){
		return eventInviteesSupported;
	}

	public String getType(){
		return type;
	}

	public List<CustomEventTypesItem> getCustomEventTypes(){
		return customEventTypes;
	}

	public String getParentId(){
		return parentId;
	}

	public String getSpaceKey(){
		return spaceKey;
	}

	public String getSpaceName(){
		return spaceName;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public boolean isRestrictable(){
		return restrictable;
	}
}