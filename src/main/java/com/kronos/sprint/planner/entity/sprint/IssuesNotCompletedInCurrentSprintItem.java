package com.kronos.sprint.planner.entity.sprint;

import java.util.List;

public class IssuesNotCompletedInCurrentSprintItem{
	private String summary;
	private String priorityName;
	private boolean estimateStatisticRequired;
	private boolean hidden;
	private String avatarUrl;
	private String statusUrl;
	private String typeName;
	private CurrentEstimateStatistic currentEstimateStatistic;
	private List<Object> fixVersions;
	private boolean done;
	private String priorityUrl;
	private EstimateStatistic estimateStatistic;
	private boolean hasCustomUserAvatar;
	private int linkedPagesCount;
	private String typeUrl;
	private String statusId;
	private String assigneeName;
	private String statusName;
	private String typeId;
	private int id;
	private String assignee;
	private int projectId;
	private String key;
	private Status status;

	public String getSummary(){
		return summary;
	}

	public String getPriorityName(){
		return priorityName;
	}

	public boolean isEstimateStatisticRequired(){
		return estimateStatisticRequired;
	}

	public boolean isHidden(){
		return hidden;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public String getStatusUrl(){
		return statusUrl;
	}

	public String getTypeName(){
		return typeName;
	}

	public CurrentEstimateStatistic getCurrentEstimateStatistic(){
		return currentEstimateStatistic;
	}

	public List<Object> getFixVersions(){
		return fixVersions;
	}

	public boolean isDone(){
		return done;
	}

	public String getPriorityUrl(){
		return priorityUrl;
	}

	public EstimateStatistic getEstimateStatistic(){
		return estimateStatistic;
	}

	public boolean isHasCustomUserAvatar(){
		return hasCustomUserAvatar;
	}

	public int getLinkedPagesCount(){
		return linkedPagesCount;
	}

	public String getTypeUrl(){
		return typeUrl;
	}

	public String getStatusId(){
		return statusId;
	}

	public String getAssigneeName(){
		return assigneeName;
	}

	public String getStatusName(){
		return statusName;
	}

	public String getTypeId(){
		return typeId;
	}

	public int getId(){
		return id;
	}

	public String getAssignee(){
		return assignee;
	}

	public int getProjectId(){
		return projectId;
	}

	public String getKey(){
		return key;
	}

	public Status getStatus(){
		return status;
	}
}