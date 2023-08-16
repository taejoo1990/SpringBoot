package com.example.myproject.controller;

import com.example.myproject.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostApiController {
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.forEach((key, value) -> {
            System.out.println(key+ " : " + value);
        });
    }
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto dto){
        System.out.println(dto.toString());
    }
}
