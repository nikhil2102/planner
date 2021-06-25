package com.kronos.sprint.planner.proxy;

import com.kronos.sprint.planner.configuration.FeignClientConfiguration;
import com.kronos.sprint.planner.entity.JiraResponse;
import com.kronos.sprint.planner.entity.JiraTeamData;
import com.kronos.sprint.planner.entity.board.AllBoards;
import com.kronos.sprint.planner.entity.capacity.CapacityResponse;
import com.kronos.sprint.planner.entity.sprint.JiraSprintDetail;
import com.kronos.sprint.planner.entity.sprint.SprintDetail;
import com.kronos.sprint.planner.entity.sprint.SprintResponse;
import com.kronos.sprint.planner.entity.sprint.SprintSummary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "jira-service", url = "https://wfrjira.int.kronos.com", configuration = FeignClientConfiguration.class)
public interface JiraServiceProxy {

    @GetMapping("/rest/tempo-teams/1/team")
    JiraTeamData[] retrieveAllTeams();

    @GetMapping("/rest/tempo-teams/2/teammember/team/{teamId}/members?from=2020-08-26&to=2020-10-26")
    JiraResponse retrieveTeamResource(@PathVariable("teamId") int teamId);

    @GetMapping("/rest/greenhopper/1.0/sprintquery/517?includeHistoricSprints=false&includeFutureSprints=false")
    SprintResponse retrieveSprints();

    @GetMapping("/rest/agile/1.0/sprint/{sprintId}")
    SprintSummary retrieveSprintSummary(@PathVariable("sprintId") int sprintId);

    @GetMapping("/rest/greenhopper/1.0/rapid/charts/sprintreport?rapidViewId=517")
    SprintDetail retrieveSprintDetail(@RequestParam("sprintId") int sprintId);

    /*@GetMapping("/rest/greenhopper/1.0/rapid/charts/sprintreport?rapidViewId=517&sprintId=12591")
    SprintDetail retrieveSprintDetail();*/

    @GetMapping("/rest/api/2/search")
    CapacityResponse retrieveAllIssues(@RequestParam(value = "jql") String jql,
                                       @RequestParam(value = "startAt") int startAt,
                                       @RequestParam(value = "maxResults") int maxResults,
                                       @RequestParam(value = "fields") String fields);

    @GetMapping("/rest/api/2/search")
    CapacityResponse retrieveIssuesByAssignee(@RequestParam(value = "jql") String jql,
                                              @RequestParam(value = "startAt") int startAt,
                                              @RequestParam(value = "maxResults") int maxResults,
                                              @RequestParam(value = "fields") String fields);

    @GetMapping("/rest/agile/1.0/board/{boardId}/sprint?state=active")
    JiraSprintDetail getBoardSprint(@RequestParam(value = "boardId") int boardId);

    @GetMapping("/rest/greenhopper/1.0/rapidviews/viewsData?query=&startAt=0&maxResults=500")
    AllBoards getAllBoards();
}
