package com.example.myproject.controller;

import com.example.myproject.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get") //http://localhost:9090/api/get
public class GetApiController {
    @GetMapping(path="/hello") //http://localhost:9090/api/get/hello
    public String hello(){
        return "get Hello";
    }
    @RequestMapping(path="hi", method = RequestMethod.GET) //http://localhost:9090/api/get/hi
    public String hi(){
        return "get Hi";
    }
    @GetMapping("/path-variable/{name}") //http://localhost:9090/api/get/path-variable/{name}
    public String pathVariable(@PathVariable(name="name") String pathName){
        System.out.println("pathVariable : " + pathName);
        return pathName;
    }

    //http://localhost:9090/api/get/query-param?user={user}&email={email}&age={age}
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey()+" = " +entry.getValue()+"\n");
        });
        return sb.toString();
    }
    //http://localhost:9090/api/get/query-param02?user={user}&email={email}&age={age}
    @GetMapping("/query-param02")
    public String queryParam02(String user, String email, int age){
        return user + email + age;
    }
    //http://localhost:9090/api/get/query-param03?user={user}&email={email}&age={age}
    @GetMapping("/query-param03")
    public String queryParam00(UserDto user){
        return user.toString();
    }
}
