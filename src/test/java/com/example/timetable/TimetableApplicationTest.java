package com.example.timetable;

import com.example.timetable.entities.peoples.Student;
import com.example.timetable.entities.timetable.StudentsEntry;
import com.example.timetable.entities.timetable.TimeTableDay;
import com.example.timetable.entities.timetable.Timetable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import de.vandermeer.asciitable.AsciiTable;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TimetableApplicationTest {
    

    @Test
    public void createTimeTable() {

    }
}