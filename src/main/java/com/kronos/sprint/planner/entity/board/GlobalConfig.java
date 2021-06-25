package com.kronos.sprint.planner.entity.board;

public class GlobalConfig{
	private SprintConfig sprintConfig;
	private String dateFormat;
	private String numberGroupingSeparator;
	private String quickCreateDefaultIssueTypeId;
	private boolean parallelSprints;
	private boolean daysInColumn;
	private EpicConfig epicConfig;
	private String dateTimePickerFormat;
	private String userTimeZoneLabel;
	private TimeTrackingConfig timeTrackingConfig;
	private boolean kanPlanLabEnabled;
	private String numberDecimalSeparator;
	private boolean isSampleDataAvailable;
	private UserConfig userConfig;

	public SprintConfig getSprintConfig(){
		return sprintConfig;
	}

	public String getDateFormat(){
		return dateFormat;
	}

	public String getNumberGroupingSeparator(){
		return numberGroupingSeparator;
	}

	public String getQuickCreateDefaultIssueTypeId(){
		return quickCreateDefaultIssueTypeId;
	}

	public boolean isParallelSprints(){
		return parallelSprints;
	}

	public boolean isDaysInColumn(){
		return daysInColumn;
	}

	public EpicConfig getEpicConfig(){
		return epicConfig;
	}

	public String getDateTimePickerFormat(){
		return dateTimePickerFormat;
	}

	public String getUserTimeZoneLabel(){
		return userTimeZoneLabel;
	}

	public TimeTrackingConfig getTimeTrackingConfig(){
		return timeTrackingConfig;
	}

	public boolean isKanPlanLabEnabled(){
		return kanPlanLabEnabled;
	}

	public String getNumberDecimalSeparator(){
		return numberDecimalSeparator;
	}

	public boolean isIsSampleDataAvailable(){
		return isSampleDataAvailable;
	}

	public UserConfig getUserConfig(){
		return userConfig;
	}
}
