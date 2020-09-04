package com.kronos.sprint.planner.entity.sprint;

import java.util.List;

public class Contents{
	private List<CompletedIssuesItem> completedIssues;
	private CompletedIssuesInitialEstimateSum completedIssuesInitialEstimateSum;
	private List<IssuesNotCompletedInCurrentSprintItem> issuesNotCompletedInCurrentSprint;
	private IssuesNotCompletedInitialEstimateSum issuesNotCompletedInitialEstimateSum;
	private PuntedIssuesEstimateSum puntedIssuesEstimateSum;
	private AllIssuesEstimateSum allIssuesEstimateSum;
	private List<IssuesCompletedInAnotherSprintItem> issuesCompletedInAnotherSprint;
	private IssuesCompletedInAnotherSprintEstimateSum issuesCompletedInAnotherSprintEstimateSum;
	private IssuesCompletedInAnotherSprintInitialEstimateSum issuesCompletedInAnotherSprintInitialEstimateSum;
	private List<PuntedIssuesItem> puntedIssues;
	private CompletedIssuesEstimateSum completedIssuesEstimateSum;
	private PuntedIssuesInitialEstimateSum puntedIssuesInitialEstimateSum;
	private IssuesNotCompletedEstimateSum issuesNotCompletedEstimateSum;
	private IssueKeysAddedDuringSprint issueKeysAddedDuringSprint;

	public List<CompletedIssuesItem> getCompletedIssues(){
		return completedIssues;
	}

	public CompletedIssuesInitialEstimateSum getCompletedIssuesInitialEstimateSum(){
		return completedIssuesInitialEstimateSum;
	}

	public List<IssuesNotCompletedInCurrentSprintItem> getIssuesNotCompletedInCurrentSprint(){
		return issuesNotCompletedInCurrentSprint;
	}

	public IssuesNotCompletedInitialEstimateSum getIssuesNotCompletedInitialEstimateSum(){
		return issuesNotCompletedInitialEstimateSum;
	}

	public PuntedIssuesEstimateSum getPuntedIssuesEstimateSum(){
		return puntedIssuesEstimateSum;
	}

	public AllIssuesEstimateSum getAllIssuesEstimateSum(){
		return allIssuesEstimateSum;
	}

	public List<IssuesCompletedInAnotherSprintItem> getIssuesCompletedInAnotherSprint(){
		return issuesCompletedInAnotherSprint;
	}

	public IssuesCompletedInAnotherSprintEstimateSum getIssuesCompletedInAnotherSprintEstimateSum(){
		return issuesCompletedInAnotherSprintEstimateSum;
	}

	public IssuesCompletedInAnotherSprintInitialEstimateSum getIssuesCompletedInAnotherSprintInitialEstimateSum(){
		return issuesCompletedInAnotherSprintInitialEstimateSum;
	}

	public List<PuntedIssuesItem> getPuntedIssues(){
		return puntedIssues;
	}

	public CompletedIssuesEstimateSum getCompletedIssuesEstimateSum(){
		return completedIssuesEstimateSum;
	}

	public PuntedIssuesInitialEstimateSum getPuntedIssuesInitialEstimateSum(){
		return puntedIssuesInitialEstimateSum;
	}

	public IssuesNotCompletedEstimateSum getIssuesNotCompletedEstimateSum(){
		return issuesNotCompletedEstimateSum;
	}

	public IssueKeysAddedDuringSprint getIssueKeysAddedDuringSprint(){
		return issueKeysAddedDuringSprint;
	}
}