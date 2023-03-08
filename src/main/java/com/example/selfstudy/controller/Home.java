package com.example.selfstudy.controller;

import com.example.selfstudy.service.MemberService;
import com.example.selfstudy.service.StudyService;
import com.example.selfstudy.vo.MemberVo;
import com.example.selfstudy.vo.Vo_study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/home")
public class Home {


    @Autowired
    StudyService studyService;

    @Autowired
    MemberService memberService;

    @GetMapping("/study_reg")
    public String doStudy_reg(HttpServletRequest request, Model model){

        List<Vo_study> list = new ArrayList<>();
        list = studyService.doStudyList();

        request.setAttribute("list", list);
        log.info(String.valueOf(list));
        System.out.println(list.getClass().getName());

        return "/home/study_reg";
    }

    @GetMapping("/member_list")
    public String doMember_list(HttpServletRequest request, Model model){

        List<MemberVo> list = new ArrayList<>();
        list = memberService.doMemberList();

        model.addAttribute("list", list);

        return "/home/member_list";
    }

}
