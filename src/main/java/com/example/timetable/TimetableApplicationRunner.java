package com.example.timetable;

import com.example.timetable.entities.peoples.Student;
import com.example.timetable.entities.timetable.StudentsEntry;
import com.example.timetable.entities.timetable.TimeTableDay;
import com.example.timetable.entities.timetable.Timetable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class TimetableApplicationRunner implements ApplicationRunner {


    @Autowired
    ObjectMapper mapper;

    @Autowired
    Faker faker;
    

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // готовим студентов
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(faker.name().fullName()));
        }

        // создаем расписание
        Timetable timetable = new Timetable();

        // создаем несколько учебных дней
        for (int i = 0; i < 3; i++) {

            // создаем  один учебный день
            LocalDate localDate = LocalDate.of(1986, Month.APRIL, 26 + i);
            TimeTableDay timeTableDay = new TimeTableDay(localDate);

            // создаем список присутствовавших на парах
            for (int j = 0; j < 5; j++) {

                // отмечаем, были ли студенты на определенной паре
                StudentsEntry entry = new StudentsEntry();
                for (Student student : students) {
                    entry.add(student, ThreadLocalRandom.current().nextBoolean());
                    timeTableDay.add(LocalTime.of(8 + j * 2, 0), entry);
                }
            }

            // добавляем учебный день в расписание
            timetable.add(timeTableDay);
        }

        // Выводим в консоль что получилось
        log.info("Посещаемость занятий: {}", timetable.toString());
        String json = mapper.writeValueAsString(timetable);
        log.info("Посещаемость занятий (json):\n {}", json);


        timetable.print();
    }
}
