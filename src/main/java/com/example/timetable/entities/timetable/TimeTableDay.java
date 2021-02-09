package com.example.timetable.entities.timetable;

import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Учебные пары за 1 день
 */
@Data
public class TimeTableDay implements Iterable<NavigableMap.Entry<LocalTime, StudentsEntry>> {

    @Setter(AccessLevel.NONE)
    private LocalDate date;

    @Setter(AccessLevel.NONE)
    private NavigableMap<LocalTime, StudentsEntry> studyHours = new TreeMap<>();


    public TimeTableDay(LocalDate date) {
        this.date = date;
    }

    public void add(LocalTime time, StudentsEntry studentsEntry) {
        studyHours.put(time, studentsEntry);
    }

    public StudentsEntry get(LocalTime time) {
        return studyHours.get(time);
    }

    @Override
    public Iterator<NavigableMap.Entry<LocalTime, StudentsEntry>> iterator() {
        return studyHours.entrySet().iterator();
    }
}
