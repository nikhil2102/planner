package com.kronos.sprint.planner.proxy;

import com.kronos.sprint.planner.configuration.FeignClientConfiguration;
import com.kronos.sprint.planner.entity.JiraResponse;
import com.kronos.sprint.planner.entity.JiraTeamData;
import com.kronos.sprint.planner.entity.sprint.SprintDetail;
import com.kronos.sprint.planner.entity.sprint.SprintSummary;
import com.kronos.sprint.planner.entity.sprint.SprintResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

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

}
