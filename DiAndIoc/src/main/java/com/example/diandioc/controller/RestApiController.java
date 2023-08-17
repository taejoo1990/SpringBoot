package com.example.diandioc.controller;

import com.example.diandioc.annotation.Decode;
import com.example.diandioc.annotation.Timer;
import com.example.diandioc.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/get/{id}")
    public String get(@PathVariable long id, @RequestParam String name){
        System.out.println("getMethod");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return id+name;
    }
    @PostMapping("/post")
    public User post(@RequestBody User user){
        System.out.println("user = " + user);
        return user;
    }
    @Timer
    @DeleteMapping("/del")
    public void delete(){
        //db logic
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println("user = " + user);
        return user;
    }
}
