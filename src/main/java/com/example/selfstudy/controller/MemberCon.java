package com.example.selfstudy.controller;

import com.example.selfstudy.service.MemberService;
import com.example.selfstudy.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberCon {

    @Autowired
    MemberService memberService;


    /* 수정(페이지 이동, 단일 리스트) */
    @GetMapping("/modify")
    public String goMod(@ModelAttribute("memberId") int memberId, Model model){

        log.info(String.valueOf(memberId));

        MemberVo list = memberService.memberListOne(memberId);

        model.addAttribute("memberVo", list);
        return "/login/member_join_mod";
    }

    /* 가입페이지 이동 */
    @GetMapping("/insert1")
    public String doInsert(){

        return "/login/member_join";
    }

    /* 등록 */
    @Transactional
    @PostMapping ("/insert")
    public String doInsert2(@ModelAttribute MemberVo memberVo){
        memberService.memberInsert(memberVo);
        return "redirect:/home/member_list";
    }

    /* 수정 */
    @Transactional
    @PostMapping ("/modify_exe")
    public String doMod(@ModelAttribute MemberVo memberVo, Model model){

        memberService.memberMod(memberVo);

        return "redirect:/home/member_list";
    }

    /* 삭제 */
    @Transactional
    @GetMapping("/delete")
    public String doDel(@ModelAttribute("memberId") int memberId){
        memberService.memberDel(memberId);
        return "redirect:/home/member_list";
    }

}
