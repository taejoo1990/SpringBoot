package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dto.Car;
import org.example.dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("hong");
        user.setAge(10);

        Car k5 = new Car();
        k5.setName("K5");
        k5.setCarNumber("11ga 1111");
        k5.setType("sedan");

        Car q5 = new Car();
        q5.setName("Q5");
        q5.setCarNumber("22ga 2222");
        q5.setType("SUV");

        List<Car> carList = Arrays.asList(k5, q5);
        user.setCars(carList);
        System.out.println("user = " + user);
        String json = objectMapper.writeValueAsString(user);
        System.out.println("json = " + json);
        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("_name = " + _name);
        System.out.println("_age = " + _age);
        ArrayNode arrayNode =  (ArrayNode)jsonNode.get("cars");
        List<Car> _cars =  objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println("_cars = " + _cars);

        ObjectNode objectNode = (ObjectNode)jsonNode;
        objectNode.put("name","lee");
        objectNode.put("age",33);
        System.out.println(objectNode.toPrettyString());
    }
}