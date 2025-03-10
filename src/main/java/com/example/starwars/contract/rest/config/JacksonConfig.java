package com.example.starwars.contract.rest.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        String json = objectMapper.writeValueAsString(offsetDateTime);
        System.out.println("Serialized JSON: " + json);



        OffsetDateTime deserializedDateTime = objectMapper.readValue(json, OffsetDateTime.class);
        System.out.println("Deserialized DateTime: " + deserializedDateTime);
        return objectMapper;
    }
}
