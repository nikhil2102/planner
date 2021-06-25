package com.kronos.sprint.planner.entity.capacity;

import java.util.List;

public class Fields{
	private String summary;
	private Issuetype issuetype;
	private List<SubtasksItem> subtasks;
	private List<IssuelinksItem> issuelinks;
	private Assignee assignee;
	private Timetracking timetracking;
	private Status status;
	private Priority priority;

	public String getSummary(){
		return summary;
	}

	public Issuetype getIssuetype(){
		return issuetype;
	}

	public List<SubtasksItem> getSubtasks(){
		return subtasks;
	}

	public List<IssuelinksItem> getIssuelinks(){
		return issuelinks;
	}

	public Assignee getAssignee(){
		return assignee;
	}

	public Timetracking getTimetracking(){
		return timetracking;
	}

	public Status getStatus(){
		return status;
	}

	public Priority getPriority(){
		return priority;
	}
}