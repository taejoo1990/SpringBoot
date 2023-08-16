package com.example.myproject.controller;

import com.example.myproject.dto.PostRequestDto;
import com.example.myproject.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/put")
public class PutApiController {
    @PutMapping("/put")
    public void put(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    @PutMapping("/put02")
    public void put02(@RequestBody PostRequestDto dto) {
        System.out.println(dto.toString());
    }

    @PutMapping("/put03")
    public void put03(@RequestBody PutRequestDto dto) {
        System.out.println(dto.toString());
    }
}
