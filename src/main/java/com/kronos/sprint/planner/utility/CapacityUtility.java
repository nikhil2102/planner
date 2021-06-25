package com.kronos.sprint.planner.utility;

import com.kronos.sprint.planner.constant.GlobalConstant;
import com.kronos.sprint.planner.entity.Resource;
import com.kronos.sprint.planner.entity.SprintCapacity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapacityUtility {

    public static float calculateAvailableCapacity(List<Resource> resources, int sprintDays, int productiveHours) {

        float availableCapacity = getTotalAvailableResourceHoursInSprint(resources, sprintDays, productiveHours);
        return availableCapacity;
    }

    public static int getMaxCapacity(int availableResources, int sprintDays, int productiveHours) {
        return sprintDays * productiveHours * availableResources;
    }

    private static float getTotalAvailableResourceHoursInSprint(List<Resource> resources, int sprintDays, int productiveHours) {
        float result = 0;
        for (Resource resource : resources) {
            result = result + ((sprintDays * productiveHours * resource.getAvailability()) / 100)
                    - absentResourceHours(resource, productiveHours);
        }
        return result;
    }

    private static float absentResourceHours(Resource resource, int productiveHours) {
        /*return resources.stream().mapToInt(Resource::getAbsentDays).sum()
                * GlobalConstant.PRODUCTIVE_RESOURCE_HOURS_PER_DAY;*/
            return (resource.getAbsentDays() * productiveHours * resource.getAvailability()) / 100;
    }

    public static float calculateCurrentVelocity(List<SprintCapacity> sprintCapacityList) {

        float currentVelocity = 0F;

        if (sprintCapacityList.size() >= 1) {
            List<Float> velocities = new ArrayList<>();

            for (SprintCapacity sprintCapacity : sprintCapacityList) {
                float f = (float) sprintCapacity.getStoryPoint() / sprintCapacity.getCapacity();
                velocities.add(f);
            }
            currentVelocity = velocities.stream().reduce(0F, Float::sum) / velocities.size();
        } else {
            System.out.println("No Past Sprints Present to calculate velocity..");
        }

        return currentVelocity;
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
