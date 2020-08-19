package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.entity.Resource;
import com.kronos.sprint.planner.entity.Sprint;
import com.kronos.sprint.planner.utility.CapacityUtility;
import com.kronos.sprint.planner.utility.SprintUtility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class CapacityController {

/*    @GetMapping("/capacity/{numberOfResources}")
    public int calculateCapacity(@PathVariable int numberOfResources) {

        int capacity = getTotalAvailableResourceHours(numberOfResources)
                - getOfficialNonWorkingDays() - getPlannedResourceLeaves();
        return capacity;
    }*/

    @PostMapping("/available-capacity")
    public int availableSprintCapacity(@RequestBody List<Resource> resources) {

        int capacity = CapacityUtility.calculateAvailableCapacity(resources);
        return capacity;
    }

    @GetMapping("/max-capacity/{availableResources}")
    public int maxSprintCapacity(@PathVariable int availableResources) {

        int maxCapacity = CapacityUtility.getMaxCapacity(availableResources);
        return maxCapacity;
    }

/*    @GetMapping("/sprint")
    public Long sprintDays(@RequestBody Sprint sprint) throws ParseException {

        return SprintUtility.getTotalSprintDays(sprint);
    }*/
}
