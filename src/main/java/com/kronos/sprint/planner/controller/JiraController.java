package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.constant.GlobalConstant;
import com.kronos.sprint.planner.entity.JiraResponse;
import com.kronos.sprint.planner.entity.JiraTeamData;
import com.kronos.sprint.planner.entity.ResourceData;
import com.kronos.sprint.planner.entity.TeamMembersItem;
import com.kronos.sprint.planner.entity.board.AllBoards;
import com.kronos.sprint.planner.entity.board.ViewsItem;
import com.kronos.sprint.planner.entity.capacity.CapacityResponse;
import com.kronos.sprint.planner.entity.capacity.IssuesItem;
import com.kronos.sprint.planner.entity.confluence.ConfluenceData;
import com.kronos.sprint.planner.entity.confluence.EventsItem;
import com.kronos.sprint.planner.entity.confluence.InviteesItem;
import com.kronos.sprint.planner.entity.confluence.space.SpaceData;
import com.kronos.sprint.planner.entity.confluence.subcalendar.ChildSubCalendarsItem;
import com.kronos.sprint.planner.entity.confluence.subcalendar.PayloadItem;
import com.kronos.sprint.planner.entity.confluence.subcalendar.SubCalendarResponse;
import com.kronos.sprint.planner.entity.sprint.JiraSprintDetail;
import com.kronos.sprint.planner.entity.sprint.SprintCapacity;
import com.kronos.sprint.planner.entity.sprint.SprintDetail;
import com.kronos.sprint.planner.entity.sprint.SprintResponse;
import com.kronos.sprint.planner.entity.sprint.SprintSummary;
import com.kronos.sprint.planner.entity.sprint.SprintsItem;
import com.kronos.sprint.planner.proxy.ConfluenceServiceProxy;
import com.kronos.sprint.planner.proxy.JiraServiceProxy;
import com.kronos.sprint.planner.utility.PlannerUtility;
import com.kronos.sprint.planner.utility.TeamSpaceEnum;
import org.bouncycastle.util.Strings;
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
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

   /* @PostMapping("/kronossprints")
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
            String endDate = sprint.getEndDate().substring(0, 10);
            ;

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
    }*/


    @GetMapping("/allboards")
    public AllBoards getAllBoards() {
        return jiraServiceProxy.getAllBoards();
    }

    @GetMapping("/boardsprint/{boardId}")
    public JiraSprintDetail getBoardSprint(@PathVariable int boardId) {
        return jiraServiceProxy.getBoardSprint(boardId);
    }

    @PostMapping("/kronossprints")
    public List<SprintDetail> getSprintsWithName1(@RequestBody String sprintName) throws ParseException {

        Map<String, List<EventsItem>> inviteesItemMap = new HashMap<>();
        Set<String> teamMembersNameSet = new HashSet<>();
        List<ConfluenceData> confluenceDataList = new ArrayList<>();
        List<SprintDetail> sprintDetailList = new ArrayList<>();
        String confluenceConstant = "T00%3A00%3A00Z";
        SprintResponse sprintResponse = jiraServiceProxy.retrieveSprints();
        List<SprintsItem> sprintsItems = sprintResponse.getSprints();

        String viewSpaceKey = TeamSpaceEnum.getValueByTeamLabel(sprintName).getSpace();
        int teamId = TeamSpaceEnum.getValueByTeamLabel(sprintName).getTeamId();

        List<SprintsItem> filteredSprintsItemsByName = sprintsItems.stream().filter(
                sprints -> sprints.getName().toUpperCase().contains(sprintName.toUpperCase())).collect(Collectors.toList());

        String formattedFirstSprintStartDate = formatSprintDate(jiraServiceProxy.retrieveSprintDetail(filteredSprintsItemsByName.
                get(0).getId()).getSprint().getStartDate().substring(0, 9));
        String formattedLastSprintEndDate = formatSprintDate(jiraServiceProxy.retrieveSprintDetail(filteredSprintsItemsByName.
                get(filteredSprintsItemsByName.size() - 1).getId()).getSprint().getStartDate().substring(0, 9));

        if (!filteredSprintsItemsByName.isEmpty()) {

            JiraResponse jiraResponse = jiraServiceProxy.retrieveTeamResource(teamId);
            if (null != jiraResponse) {
                List<TeamMembersItem> teamMembersItemList = jiraResponse.getTeamMembers();

                if (null != teamMembersItemList && !teamMembersItemList.isEmpty()) {
                    for (TeamMembersItem teamMembersItem : teamMembersItemList) {
                        teamMembersNameSet.add(teamMembersItem.getName());
                    }
                }
            }
            Set<String> subCalendarIdSet = new HashSet<>();
            SubCalendarResponse subCalendarResponse = getSubCalendars(viewSpaceKey);
            List<PayloadItem> payloadItems = subCalendarResponse.getPayload();

            if (null != payloadItems) {
                for (PayloadItem payloadItem : payloadItems) {
                    List<ChildSubCalendarsItem> childSubCalendarsItemList = payloadItem.getChildSubCalendars();

                    if (null != childSubCalendarsItemList && !childSubCalendarsItemList.isEmpty()) {
                        for (ChildSubCalendarsItem childSubCalendarsItem : childSubCalendarsItemList) {
                            if (null != childSubCalendarsItem.getSubCalendar()) {
                                String subCalendarId = childSubCalendarsItem.getSubCalendar().getId();
                                subCalendarIdSet.add(subCalendarId);
                            }
                        }
                    }
                }
            }

            if (!subCalendarIdSet.isEmpty()) {

                for (String eachSubCalendarId : subCalendarIdSet) {
                    ConfluenceData confluenceDataForSubCalendarId = getConfluenceData(eachSubCalendarId, formattedFirstSprintStartDate, formattedLastSprintEndDate);
                    if (null != confluenceDataForSubCalendarId.getEvents() && !confluenceDataForSubCalendarId.getEvents().isEmpty()) {
                        confluenceDataList.add(confluenceDataForSubCalendarId);
                    }
                }
            }

            for (ConfluenceData eachConfluenceData : confluenceDataList) {

                if (null != eachConfluenceData && null != eachConfluenceData.getEvents()
                        && !eachConfluenceData.getEvents().isEmpty()) {

                    List<EventsItem> events = eachConfluenceData.getEvents();
                    for (EventsItem eachEventsItem : events) {

                        if (null != eachEventsItem && null != eachEventsItem.getInvitees() && !eachEventsItem.getInvitees().isEmpty()) {

                            InviteesItem inviteesItem = eachEventsItem.getInvitees().get(0);
                            if (teamMembersNameSet.contains(inviteesItem.getName())) {

                                if (null == inviteesItemMap.get(inviteesItem.getName())) {
                                    inviteesItemMap.put(inviteesItem.getName(), new ArrayList<>());
                                    inviteesItemMap.get(inviteesItem.getName()).add(eachEventsItem);
                                } else {
                                    inviteesItemMap.get(inviteesItem.getName()).add(eachEventsItem);
                                }
                            }
                        }
                    }
                }
            }

            for (SprintsItem eachSprint : filteredSprintsItemsByName) {

                int sprintId = eachSprint.getId();
                SprintDetail sprintDetail = jiraServiceProxy.retrieveSprintDetail(sprintId);
                sprintDetailList.add(sprintDetail);
            }

            if (!inviteesItemMap.isEmpty()) {

                for (String teamMember : inviteesItemMap.keySet()) {
                    List<EventsItem> eventsItemList = inviteesItemMap.get(teamMember);

                    for (EventsItem eventsItem : eventsItemList) {
                        String startDate = eventsItem.getLocalizedStartDate();
                        String endDate = eventsItem.getLocalizedEndDate();

                        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");

                        try {
                            Date date1 = myFormat.parse(startDate);
                            Date date2 = myFormat.parse(endDate);

                            LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                            long result = calcWeekDays(localDate1, localDate2);

                            long diff = (date2.getTime() - date1.getTime()) + 24 * 60 * 60 * 1000;
                            long daysOff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

                            System.out.println("Days Off for " + teamMember + " : " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            if (!inviteesItemMap.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

                for (SprintDetail sprintDetail : sprintDetailList) {

                    int sprintLeaveCounter = 0;

                    LocalDate sprintStartLocalDate = sdf.parse(sprintDetail.getSprint().getStartDate().substring(0, 9)).
                            toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    LocalDate sprintEndLocalDate = sdf.parse(sprintDetail.getSprint().getEndDate().substring(0, 9)).
                            toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


                    List<EventsItem> eventsItemList = inviteesItemMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
                    for (EventsItem eventsItem : eventsItemList) {

                        LocalDate leaveStartDate = LocalDate.parse(eventsItem.getLocalizedStartDate(), formatter);
                        LocalDate leaveEndDate = LocalDate.parse(eventsItem.getLocalizedEndDate(), formatter);

                        while (leaveStartDate.isBefore(leaveEndDate) || leaveStartDate.isEqual(leaveEndDate)) {

                            if (leaveStartDate.isAfter(sprintEndLocalDate)) {
                                break;
                            } else if (leaveStartDate.isBefore(sprintStartLocalDate)) {
                                leaveStartDate = leaveStartDate.plusDays(1);
                            } else if ((leaveStartDate.isEqual(sprintStartLocalDate)
                                    || leaveStartDate.isAfter(sprintStartLocalDate))
                                    && (leaveStartDate.isBefore(sprintEndLocalDate)
                                    || leaveStartDate.isEqual(sprintEndLocalDate))) {

                                sprintLeaveCounter++;
                                leaveStartDate = leaveStartDate.plusDays(1);
                            }
                        }
                    }
                    System.out.println(LocalDateTime.now() + " :: Leaves for Sprint " + sprintDetail.getSprint().getName() + " is : " + sprintLeaveCounter);
                    sprintDetail.setSprintCapacity
                            (new SprintCapacity(sprintLeaveCounter,
                                    (teamMembersNameSet.size() * GlobalConstant.PRODUCTIVE_RESOURCE_HOURS_PER_DAY * GlobalConstant.SPRINT_DAYS) -
                                            (sprintLeaveCounter * GlobalConstant.PRODUCTIVE_RESOURCE_HOURS_PER_DAY)));
                }
            }
        }
        return sprintDetailList;
    }


    private static long calcWeekDays(final LocalDate start, final LocalDate end) {
        final DayOfWeek startW = start.getDayOfWeek();
        final DayOfWeek endW = end.getDayOfWeek();
        final long days = ChronoUnit.DAYS.between(start, end);
        final long daysWithoutWeekends = days - 2 * ((days + startW.getValue()) / 7);

        //adjust for starting and ending on a Sunday:
        return daysWithoutWeekends + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0) + 1;
    }

    private String formatSprintDate(String date) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = format1.parse(date);
        String newDate = format2.format(parsedDate) + "T00%3A00%3A00Z";
        return newDate;
    }


    @GetMapping("/confluencedata/{subCalendarId}/{userTimeZoneId}/{start}/{end}")
    public ConfluenceData getConfluenceData1(@PathVariable String subCalendarId,
                                             @PathVariable String userTimeZoneId,
                                             @PathVariable String start,
                                             @PathVariable String end) {

        return confluenceServiceProxy.retrieveConfluenceData(subCalendarId, userTimeZoneId, start, end);
    }

    private ConfluenceData getConfluenceData(String subCalendarId, String start, String end) {
        String userTimeZoneId = "Asia%2FCalcutta";
        ConfluenceData confluenceData = confluenceServiceProxy.retrieveConfluenceData(subCalendarId, userTimeZoneId, start, end);
        return confluenceData;
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

    @GetMapping("/subcalendar/{viewspacekey}")
    public SubCalendarResponse getSubCalendars(@PathVariable String viewspacekey) {
        SubCalendarResponse subCalendarResponse = confluenceServiceProxy.retreiveSubCalendarData(Strings.toUpperCase(viewspacekey));
        return subCalendarResponse;
    }

    @GetMapping("/kronosspace/{pageSize}/{startIndex}")
    public SpaceData getSpaceDataJson(@PathVariable int pageSize, @PathVariable int startIndex) {
        SpaceData spaceData = confluenceServiceProxy.retrieveSpaceData(pageSize, startIndex);
        return spaceData;
    }

}
