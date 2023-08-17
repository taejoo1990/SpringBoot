package com.example.myproject.controller;

import com.example.myproject.dto.People;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }
    //Response-text
    @GetMapping("/text") //localhost:9090/api/text?account={account}
    public String text(@RequestParam String account){
        return account;
    }
    //Response-json
    //req - object - parse - process - parse - return Json
    @PostMapping("/json") //localhost:9090/api/json
    public People json(@RequestBody People people){
        System.out.println("people = " + people);
        return people;
    }

    @PutMapping("/put")
    public ResponseEntity<People> put(@RequestBody People people){
        return ResponseEntity.status(HttpStatus.CREATED).body(people);
    }
}
