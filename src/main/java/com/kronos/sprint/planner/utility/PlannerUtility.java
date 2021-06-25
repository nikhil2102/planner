package com.kronos.sprint.planner.utility;

import com.kronos.sprint.planner.constant.GlobalConstant;
import com.kronos.sprint.planner.entity.Sprint;
import com.kronos.sprint.planner.entity.capacity.IssuesItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PlannerUtility {

    public static Long getTotalSprintDays(Sprint sprint) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(sprint.getSprintStartDate());
        Date secondDate = sdf.parse(sprint.getSprintEndDate());

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;
    }

    public static String getAssigneeName(IssuesItem issuesItem) {
        return issuesItem.getFields().getAssignee() == null ? GlobalConstant.UNASSIGNED_TEAMMATE :
                issuesItem.getFields().getAssignee().getDisplayName();
    }

    public static void calculateTime(long seconds) {
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);

        System.out.println("Day " + day + " Hour " + hours + " Minute " + minute + " Seconds " + second);
        System.out.println(seconds);
    }
}
