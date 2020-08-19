package com.kronos.sprint.planner.utility;

import com.kronos.sprint.planner.entity.Sprint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SprintUtility {

    public static Long getTotalSprintDays(Sprint sprint) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(sprint.getSprintStartDate());
        Date secondDate = sdf.parse(sprint.getSprintEndDate());

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;
    }
}
