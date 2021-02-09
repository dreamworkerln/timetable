package com.example.timetable.entities.timetable;

import com.example.timetable.entities.peoples.Student;
import lombok.ToString;

import java.util.*;


/**
 * Список присутствующих/отсутствующих студентов на одной паре
 * <br>(Long - id студента)
 */
@ToString
public class StudentsEntry implements Iterable<NavigableMap.Entry<Student, Boolean>> {

    private final NavigableMap<Student, Boolean> presence = new TreeMap<>();

    public void add(Student student, boolean isPresent) {
        presence.put(student, isPresent);
    }

    public boolean get(Student student) {
        return presence.get(student);
    }
    

    @Override
    public Iterator<NavigableMap.Entry<Student, Boolean>> iterator() {
        return presence.entrySet().iterator();
    }
}
