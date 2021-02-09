package com.example.timetable.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class SpringBeans {

    @Bean
    public ObjectMapper getObjectMapper() {

        ObjectMapper result = new ObjectMapper();
        result.registerModule(new JavaTimeModule());
        result.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return result;
    }

    @Bean
    Faker getFaker() {
        return new Faker(new Locale("ru-RU"));
    }


}
