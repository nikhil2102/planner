package com.kronos.sprint.planner.entity.confluence.subcalendar;

import java.util.List;

public class ChildSubCalendarsItem{
	private boolean reminderMe;
	private List<Object> groupsPermittedToView;
	private boolean hidden;
	private boolean subscribedByCurrentUser;
	private SubCalendar subCalendar;
	private boolean editable;
	private List<Object> warnings;
	private boolean reloadable;
	private boolean deletable;
	private boolean eventsHidden;
	private boolean watchedViaContent;
	private List<Object> usersPermittedToEdit;
	private boolean administrable;
	private List<Object> usersPermittedToView;
	private boolean watched;
	private boolean eventsViewable;
	private List<Object> groupsPermittedToEdit;
	private int subscriberCount;
	private boolean eventsEditable;

	public boolean isReminderMe(){
		return reminderMe;
	}

	public List<Object> getGroupsPermittedToView(){
		return groupsPermittedToView;
	}

	public boolean isHidden(){
		return hidden;
	}

	public boolean isSubscribedByCurrentUser(){
		return subscribedByCurrentUser;
	}

	public SubCalendar getSubCalendar(){
		return subCalendar;
	}

	public boolean isEditable(){
		return editable;
	}

	public List<Object> getWarnings(){
		return warnings;
	}

	public boolean isReloadable(){
		return reloadable;
	}

	public boolean isDeletable(){
		return deletable;
	}

	public boolean isEventsHidden(){
		return eventsHidden;
	}

	public boolean isWatchedViaContent(){
		return watchedViaContent;
	}

	public List<Object> getUsersPermittedToEdit(){
		return usersPermittedToEdit;
	}

	public boolean isAdministrable(){
		return administrable;
	}

	public List<Object> getUsersPermittedToView(){
		return usersPermittedToView;
	}

	public boolean isWatched(){
		return watched;
	}

	public boolean isEventsViewable(){
		return eventsViewable;
	}

	public List<Object> getGroupsPermittedToEdit(){
		return groupsPermittedToEdit;
	}

	public int getSubscriberCount(){
		return subscriberCount;
	}

	public boolean isEventsEditable(){
		return eventsEditable;
	}
}