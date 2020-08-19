package com.kronos.sprint.planner.utility;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomHolidays {

    private final Set<MonthDay> holidays = new HashSet<>();

    public void addHoliday(final MonthDay monthDay) {
        holidays.add(monthDay);
    }

    public boolean isHoliday(final LocalDate localDate) {
        return isWeekend(localDate) || holidays.contains(toMonthDay(localDate));
    }

    public int numberOfWorkdaysBetween(final LocalDate startInclusive, final LocalDate endInclusive) {
        int c = 0;
        for (LocalDate i = startInclusive; !i.isAfter(endInclusive); i = i.plusDays(1)) {
            if (!isHoliday(i)) {
                c++;
            }
        }
        return c;
    }

    private boolean isWeekend(final LocalDate localDate) {
        final DayOfWeek dow = localDate.getDayOfWeek();
        return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
    }

    private static MonthDay toMonthDay(final LocalDate localDate) {
        return MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
    }

    public static void main(String[] args) {
        final CustomHolidays ch = new CustomHolidays();
        ch.addHoliday(MonthDay.of(Month.OCTOBER, 2));
        ch.addHoliday(MonthDay.of(Month.NOVEMBER, 16));
        ch.addHoliday(MonthDay.of(Month.NOVEMBER, 30));
        ch.addHoliday(MonthDay.of(Month.DECEMBER, 25));

        System.out.println(ch.numberOfWorkdaysBetween(LocalDate.of(2018, 5, 1), LocalDate.of(2018, 5, 8)));
    }
}
