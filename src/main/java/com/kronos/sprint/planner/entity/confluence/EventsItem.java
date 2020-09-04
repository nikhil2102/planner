package com.kronos.sprint.planner.entity.confluence;

import java.util.List;

public class EventsItem{
	private String borderColor;
	private String description;
	private String className;
	private String title;
	private boolean allDay;
	private String iconLink;
	private String localizedStartDate;
	private String confluenceFormattedStartDate;
	private List<InviteesItem> invitees;
	private String end;
	private String id;
	private String iconUrl;
	private String customEventTypeId;
	private String localizedEndDate;
	private String originalStartDateTime;
	private String backgroundColor;
	private String mediumIconUrl;
	private boolean expandDates;
	private String originalEndTime;
	private boolean editable;
	private String start;
	private String originalStartTime;
	private String eventType;
	private String textColor;
	private String subCalendarId;
	private String localizedOriginalStartDate;
	private String secondaryBorderColor;
	private String localizedEndTime;
	private boolean calendarReloadRequiredOnUpdate;
	private String originalEndDateTime;
	private String localizedStartTime;
	private String localizedOriginalEndDate;
	private String colorScheme;

	public String getBorderColor(){
		return borderColor;
	}

	public String getDescription(){
		return description;
	}

	public String getClassName(){
		return className;
	}

	public String getTitle(){
		return title;
	}

	public boolean isAllDay(){
		return allDay;
	}

	public String getIconLink(){
		return iconLink;
	}

	public String getLocalizedStartDate(){
		return localizedStartDate;
	}

	public String getConfluenceFormattedStartDate(){
		return confluenceFormattedStartDate;
	}

	public List<InviteesItem> getInvitees(){
		return invitees;
	}

	public String getEnd(){
		return end;
	}

	public String getId(){
		return id;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public String getCustomEventTypeId(){
		return customEventTypeId;
	}

	public String getLocalizedEndDate(){
		return localizedEndDate;
	}

	public String getOriginalStartDateTime(){
		return originalStartDateTime;
	}

	public String getBackgroundColor(){
		return backgroundColor;
	}

	public String getMediumIconUrl(){
		return mediumIconUrl;
	}

	public boolean isExpandDates(){
		return expandDates;
	}

	public String getOriginalEndTime(){
		return originalEndTime;
	}

	public boolean isEditable(){
		return editable;
	}

	public String getStart(){
		return start;
	}

	public String getOriginalStartTime(){
		return originalStartTime;
	}

	public String getEventType(){
		return eventType;
	}

	public String getTextColor(){
		return textColor;
	}

	public String getSubCalendarId(){
		return subCalendarId;
	}

	public String getLocalizedOriginalStartDate(){
		return localizedOriginalStartDate;
	}

	public String getSecondaryBorderColor(){
		return secondaryBorderColor;
	}

	public String getLocalizedEndTime(){
		return localizedEndTime;
	}

	public boolean isCalendarReloadRequiredOnUpdate(){
		return calendarReloadRequiredOnUpdate;
	}

	public String getOriginalEndDateTime(){
		return originalEndDateTime;
	}

	public String getLocalizedStartTime(){
		return localizedStartTime;
	}

	public String getLocalizedOriginalEndDate(){
		return localizedOriginalEndDate;
	}

	public String getColorScheme(){
		return colorScheme;
	}
}