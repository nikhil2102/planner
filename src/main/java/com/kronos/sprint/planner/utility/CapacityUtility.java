package com.kronos.sprint.planner.utility;

import com.kronos.sprint.planner.constant.GlobalConstant;
import com.kronos.sprint.planner.entity.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacityUtility {

    public static int calculateAvailableCapacity(List<Resource> resources) {

        int availableCapacity = getTotalAvailableResourceHoursInSprint(resources);
        return availableCapacity;
    }

    public static int getMaxCapacity(int availableResources) {
        return GlobalConstant.SPRINT_DAYS * GlobalConstant.PRODUCTIVE_RESOURCE_HOURS_PER_DAY * availableResources;
    }

    private static int getTotalAvailableResourceHoursInSprint(List<Resource> resources) {
        return resources.size() * GlobalConstant.PRODUCTIVE_RESOURCE_HOURS_PER_DAY * GlobalConstant.SPRINT_DAYS
                - absentResourceHours(resources);
    }

    private static int absentResourceHours(List<Resource> resources) {
        return resources.stream().mapToInt(Resource::getAbsentDays).sum()
                * GlobalConstant.PRODUCTIVE_RESOURCE_HOURS_PER_DAY;
    }

    private int getOfficialNonWorkingDays() {
        return getOfficialHolidays() + getWeekOffs();
    }

    private int getWeekOffs() {
        return 4;
    }

    private int getPlannedResourceLeaves() {
        return 3;
    }

    private int getOfficialHolidays() {
        return 2;
    }
}
