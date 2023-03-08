package com.example.selfstudy.controller;

import com.example.selfstudy.service.MemService;
import com.example.selfstudy.service.imp.MemImp;
import com.example.selfstudy.vo.MemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/newMem/")
public class MemControl {

    @Autowired
    private MemService memService;

    // SAVE
    @PostMapping("/insert")
    public String addMember(@ModelAttribute MemVo memVo, Model model){

        System.out.println("email =>" + memVo.getEmail());
        System.out.println("phone =>" + memVo.getPhone());
        System.out.println("baseAdres =>" + memVo.getBaseAdres());
        System.out.println("memId =>" + memVo.getMemId());
        System.out.println("memName =>" + memVo.getMemName());
        System.out.println("memPassword =>" + memVo.getMemPassword());

        String memNo = memService.createMemberNumber();
        System.out.println("컨틀롤러가 받은 memNo => " + memNo);

        memVo.setMemNo(memNo);
        String msg = null;
        int result = memService.joinMembership(memVo);

        /*  유효성 검사한거 if문으로 돌려서 다시 검사해보기  */
        if (result == 1) {
            msg = "입력하지 않은 정보가 있습니다.";
        } else if (result == 2) {
            msg = "이름은 한글만 입력해주세요.";
        } else if (result == 3) {
            msg = "비밀번호가 형식에 맞지 않습니다.";
        } else if (result == 4) {
            msg = "이메일이 형식에 맞지 않습니다.";
        } else if (result == 5) {
            msg = "핸드폰 번호 형식에 맞지 않습니다.";
        }

        if(msg != null){
           model.addAttribute("msg",msg);
           return "/login/member_join";
        }
        model.addAttribute("memVo", memVo);
        return "/login/welcome";
    }
}
