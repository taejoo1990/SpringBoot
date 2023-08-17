package com.example.myproject.controller;

import com.example.myproject.dto.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/people")
    public People poeple(){
        var people = new People();
        people.setAccount("lee");
        people.setAge(33);
        people.setBirth("1990.06.02");
        return people;
    }
}
