package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.entity.JiraResponse;
import com.kronos.sprint.planner.entity.JiraTeamData;
import com.kronos.sprint.planner.entity.confluence.ConfluenceData;
import com.kronos.sprint.planner.entity.sprint.Sprint;
import com.kronos.sprint.planner.entity.sprint.SprintDetail;
import com.kronos.sprint.planner.entity.sprint.SprintResponse;
import com.kronos.sprint.planner.entity.sprint.SprintSummary;
import com.kronos.sprint.planner.entity.sprint.SprintsItem;
import com.kronos.sprint.planner.proxy.ConfluenceServiceProxy;
import com.kronos.sprint.planner.proxy.JiraServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class JiraController {

    @Autowired
    JiraServiceProxy jiraServiceProxy;

    @Autowired
    ConfluenceServiceProxy confluenceServiceProxy;

    @GetMapping("/kronosteams")
    public JiraTeamData[] getTeams() {

        JiraTeamData[] jiraTeamDataResponse = jiraServiceProxy.retrieveAllTeams();
        return jiraTeamDataResponse;
    }

    @GetMapping("/kronosteams/resources/{teamId}")
    public @ResponseBody
    JiraResponse getTeamResources(@PathVariable int teamId) {

        JiraResponse jiraTeamResourceDataJiraResponse = jiraServiceProxy.retrieveTeamResource(teamId);
        return jiraTeamResourceDataJiraResponse;
    }

    @GetMapping("/kronossprints")
    public SprintResponse getSprints() {
        SprintResponse sprintResponse = jiraServiceProxy.retrieveSprints();
        return sprintResponse;
    }

    @PostMapping("/kronossprints")
    public List<SprintDetail> getSprintsWithName(@RequestBody String sprintName) throws ParseException {

        List<SprintDetail> sprintDetailList = new ArrayList<>();
        SprintResponse sprintResponse = jiraServiceProxy.retrieveSprints();
        List<SprintsItem> sprintsItems = sprintResponse.getSprints();

        List<SprintsItem> filteredSprintsItemsByName = sprintsItems.stream().filter(
                sprints -> sprints.getName().toUpperCase().contains(sprintName.toUpperCase())).collect(Collectors.toList());

        for (SprintsItem eachSprint : filteredSprintsItemsByName) {
            int sprintId = eachSprint.getId();
            SprintDetail sprintDetail = jiraServiceProxy.retrieveSprintDetail(sprintId);

            Sprint sprint = sprintDetail.getSprint();
            String startDate = sprint.getStartDate().substring(0, 9);
            String endDate = sprint.getEndDate().substring(0, 10);;

            SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yy");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format1.parse(startDate);
            Date date2 = format1.parse(endDate);
            String newStartDate = format2.format(date1);
            String newEndDate = format2.format(date2);

//            ConfluenceData confluenceData = getConfluenceData(newStartDate, newEndDate);

            sprintDetailList.add(sprintDetail);
        }

        return sprintDetailList;
    }

    @GetMapping("/confluencedata")
    public ConfluenceData getConfluenceData() {
        String confluenceConstant = "T00%3A00%3A00Z";

//        return confluenceServiceProxy.retrieveConfluenceData();

        String startDate = "2020-07-31" + confluenceConstant;
        String endDate = "2020-11-09" + confluenceConstant;
        return getConfluenceData(startDate, endDate);
    }

    @GetMapping("/confluencedata/{subCalendarId}/{userTimeZoneId}/{start}/{end}")
    public ConfluenceData getConfluenceData1(@PathVariable String subCalendarId,
                                             @PathVariable String userTimeZoneId,
                                             @PathVariable String start,
                                             @PathVariable String end) {

        return confluenceServiceProxy.retrieveConfluenceData(subCalendarId, userTimeZoneId, start, end);
    }

    private ConfluenceData getConfluenceData(String startDate, String endDate) {
        String subCalendarId = "699f80a3-991b-4f05-966a-2153a3f3628e";
        String userTimeZoneId = "Asia%2FCalcutta";
        return confluenceServiceProxy.retrieveConfluenceData(subCalendarId, userTimeZoneId, startDate, endDate);
    }

    @GetMapping("/kronossprintsummary/{sprintId}")
    public SprintSummary getSprintSummary(@PathVariable int sprintId) {
        SprintSummary sprintSummary = jiraServiceProxy.retrieveSprintSummary(sprintId);
        return sprintSummary;
    }

    @GetMapping("/kronossprintdetail/{sprintId}")
    public SprintDetail getSprintDetail(@PathVariable int sprintId) {
        SprintDetail sprintDetail = jiraServiceProxy.retrieveSprintDetail(sprintId);
        return sprintDetail;
    }

}
