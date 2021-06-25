package com.kronos.sprint.planner.proxy;

import com.kronos.sprint.planner.configuration.FeignClientConfiguration;
import com.kronos.sprint.planner.entity.confluence.ConfluenceData;
import com.kronos.sprint.planner.entity.confluence.space.SpaceData;
import com.kronos.sprint.planner.entity.confluence.subcalendar.SubCalendarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "confluence-service", url = "https://wfrconf.int.kronos.com", configuration = FeignClientConfiguration.class)
public interface ConfluenceServiceProxy {

    @GetMapping
            ("/rest/calendar-services/1.0/calendar/events.json?subCalendarId=699f80a3-991b-4f05-966a-2153a3f3628e&userTimeZoneId=Asia%2FCalcutta&start=2020-07-31T00%3A00%3A00Z&end=2020-11-09T00%3A00%3A00Z")
    ConfluenceData retrieveConfluenceData();

    @GetMapping("/rest/calendar-services/1.0/calendar/events.json")
    ConfluenceData retrieveConfluenceData(@RequestParam("subCalendarId") String subCalendarId,
                                          @RequestParam("userTimeZoneId") String userTimeZoneId,
                                          @RequestParam("start") String start, @RequestParam("end") String end);

    @GetMapping("/rest/calendar-services/1.0/calendar/subcalendars.json?calendarContext=spaceCalendars")
    SubCalendarResponse retreiveSubCalendarData(@RequestParam("viewingSpaceKey") String viewingSpaceKey);

    @GetMapping(value = "/rest/spacedirectory/1/search?query=&status=current", produces = "application/json")
    SpaceData retrieveSpaceData(@RequestParam("pageSize") int pageSize,
                                @RequestParam("startIndex") int startIndex);
}
