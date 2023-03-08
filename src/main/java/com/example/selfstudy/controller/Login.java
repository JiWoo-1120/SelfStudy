package com.example.selfstudy.controller;

import com.example.selfstudy.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Login {


    @Autowired
    StudyService studyService;

    @RequestMapping("/login")
    public String doLogin(){return "/login/login";}

    @RequestMapping("/member_join")
    public String doMemberJoin(){return "/login/member_join";}


}
