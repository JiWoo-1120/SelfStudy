package com.example.selfstudy.controller;

import com.example.selfstudy.service.StudyService;
import com.example.selfstudy.vo.Vo_study;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@Controller
@RequestMapping("/study_reg")
public class StudyRegCon {

    @Autowired
    StudyService studyService;

    /* 등록하기 페이지 이동 */
    @GetMapping("/insert")
    public String doIns(){
        return "/study/study_ins";
    }


    /* 등록하기 기능 */
    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Vo_study vo_study){

        studyService.doStudyIns(vo_study);

        return "redirect:/home/study_reg";
    }


    /* 상세페이지 */
    @GetMapping("/modify")
    public String doMod(HttpServletRequest request){

        String strId = request.getParameter("id");
        log.info(strId);

        Vo_study vo_study = new Vo_study();

        vo_study = studyService.doStudyListOne(strId);


        request.setAttribute("vo_study", vo_study);

        return "/study/study_mod";
    }

    /* 수정(업데이트) */
    @PostMapping("/modify_exe")
    public String doModExe(@ModelAttribute("vo_study") Vo_study vo_study){

        int intI = studyService.doStudyUp(vo_study);

        System.out.println("--------------------------------------------------");
        System.out.println("id => " + vo_study.getId());
        System.out.println("studyDay => " + vo_study.getStudyDay());
        System.out.println("contents => " + vo_study.getContents());
        System.out.println("regDay => " + vo_study.getRegDay());
        System.out.println("--------------------------------------------------");

        return "redirect:/home/study_reg";
    }


    /* 삭제 */
    @Transactional
    @GetMapping("/delete")
    public String doDel(@RequestParam(value ="id") Long id){

        studyService.doStudyDel(id);

        return "redirect:/home/study_reg";
    }


}
