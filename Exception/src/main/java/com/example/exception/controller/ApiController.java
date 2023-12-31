package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("")
    public User get(@RequestParam(required = false) @Valid String name, @RequestParam(required = false) @Valid Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int a = 10 + age;


        return user;
    }
    @PostMapping("")
    public User post(@RequestBody @Valid User user){
        return user;
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("include Class --------");
    }
}
