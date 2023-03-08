package com.example.selfstudy.controller;

import com.example.selfstudy.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// 메인화면


@Controller
public class Frist {


    @GetMapping("")
    public String doHome(){return "/home/home";}

}
