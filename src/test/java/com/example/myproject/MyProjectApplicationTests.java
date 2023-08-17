package com.example.myproject;

import com.example.myproject.dto.People;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyProjectApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello");

        var om = new ObjectMapper();
        People people = new People("lee",33);

        String text = null;
        People a = null;
        try {
            text = om.writeValueAsString(people);
            a=om.readValue(text, People.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("text = " + text);
        System.out.println("a = " + a);
    }

}
