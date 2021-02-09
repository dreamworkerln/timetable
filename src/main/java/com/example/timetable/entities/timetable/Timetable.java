package com.example.timetable.entities.timetable;

import com.example.timetable.entities.peoples.Student;
import de.vandermeer.asciitable.AsciiTable;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


/**
 * Расписание занятий
 */
@ToString
public class Timetable implements Iterable<NavigableMap.Entry<LocalDate, TimeTableDay>> {

    @Setter(AccessLevel.NONE)
    private NavigableMap<LocalDate, TimeTableDay> timetable = new TreeMap<>();

    public void add(TimeTableDay timeTableDay) {
        timetable.put(timeTableDay.getDate(), timeTableDay);
    }


    @Override
    public Iterator<Map.Entry<LocalDate, TimeTableDay>> iterator() {
        return timetable.entrySet().iterator();
    }


    public void print() {

        AsciiTable at = new AsciiTable();

        for (NavigableMap.Entry<LocalDate, TimeTableDay> dayEntry : timetable.entrySet()) {
            //at.addRow("", "");
            at.addRule();
            at.addRule();
            at.addRow(dayEntry.getKey(), "");
            //at.addRow("", "");


            //System.out.println("\n\n" + dayEntry.getKey()+"\n");

            for (NavigableMap.Entry<LocalTime, StudentsEntry> pairEntry : dayEntry.getValue()) {

                //at.addRow("", "");
                at.addRule();
                at.addRow(pairEntry.getKey(), "");
                at.addRow("", "");
                //System.out.println("\n" +pairEntry.getKey()+"\n");

                for (NavigableMap.Entry<Student, Boolean> studentEntry : pairEntry.getValue()) {
                    at.addRule();
                    at.addRow(studentEntry.getKey(), studentEntry.getValue());
                }

            }

        }
        at.addRule();

        String rend = at.render();
        System.out.println(rend);
        
    }

}
