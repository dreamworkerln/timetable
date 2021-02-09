package com.example.timetable.entities.peoples;

import lombok.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Студент, id - уникальный идентификатор
 */
@Data
public class Student implements Comparable {

    private static AtomicLong idGen = new AtomicLong();

    @Setter(AccessLevel.NONE)
    private Long id;

    @Setter(AccessLevel.NONE)
    private String name;

    public Student(String name) {
        this.id = idGen.getAndIncrement();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Student)o).name);
    }
}
