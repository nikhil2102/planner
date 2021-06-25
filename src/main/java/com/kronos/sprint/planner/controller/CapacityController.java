package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.entity.Resource;
import com.kronos.sprint.planner.entity.SprintCapacity;
import com.kronos.sprint.planner.utility.CapacityUtility;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CapacityController {

/*    @GetMapping("/capacity/{numberOfResources}")
    public int calculateCapacity(@PathVariable int numberOfResources) {

        int capacity = getTotalAvailableResourceHours(numberOfResources)
                - getOfficialNonWorkingDays() - getPlannedResourceLeaves();
        return capacity;
    }*/

    @PostMapping("/available-capacity")
    public int availableSprintCapacity(@RequestBody List<Resource> resources) {

        float capacity = CapacityUtility.calculateAvailableCapacity(resources, sprintDays, productiveHours);
        return capacity;
    }

    @GetMapping("/max-capacity/{availableResources}/{sprintDays}/{productiveHours}")
    public int maxSprintCapacity(@PathVariable int availableResources, @PathVariable int sprintDays,
                                 @PathVariable int productiveHours) {

        int maxCapacity = CapacityUtility.getMaxCapacity(availableResources, sprintDays, productiveHours);
        return maxCapacity;
    }

    @PostMapping("/currentvelocity")
    public float getCurrentVelocity(@RequestBody List<SprintCapacity> sprintCapacityList) {

        float currentCapacity = CapacityUtility.calculateCurrentVelocity(sprintCapacityList);
        return currentCapacity;
    }

}
