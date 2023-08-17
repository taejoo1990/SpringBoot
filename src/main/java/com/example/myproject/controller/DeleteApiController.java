package com.example.myproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/del")
public class DeleteApiController {
    @DeleteMapping("/del/{userId}") //http://localhost:9090/api/del/del/{userId}?account={account}
    public void delete(@PathVariable String userId, @RequestParam String account){
        System.out.println(userId);
        System.out.println(account);
    }
}
