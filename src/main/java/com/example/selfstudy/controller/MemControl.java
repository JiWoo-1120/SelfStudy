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

    // SAVE(회원가입)
    @PostMapping("/insert")
    public String addMember(@ModelAttribute MemVo memVo, Model model) throws Exception {

        // 회원번호 만들기
        String memNo = memService.createMemberNumber();
        System.out.println("컨틀롤러가 받은 memNo => " + memNo);
        memVo.setMemNo(memNo);
        memVo.setMemPasswordSalt("00");

        // 유효성 검사
        String msg = null;
        int result = memService.chkValidation(memVo);
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

        // 양방향 암호화 AES-256
        MemVo encryptedData = memService.encryptionAES(memVo);

        // 비밀번호 암호화 (단방향 암호화 SHA-256)
        encryptedData = memService.encryptionSHA(encryptedData);

        // 데이터 저장
        memService.joinMembership(encryptedData);

        // 양방향 복호화 AES-256
        memService.decryptionAES(encryptedData);
        System.out.println(encryptedData.getMemName());
        System.out.println(encryptedData.getEmail());
        System.out.println(encryptedData.getZipcode());
        System.out.println(encryptedData.getBaseAdres());
        System.out.println(encryptedData.getDetailAdres());
        System.out.println(encryptedData.getPhone());


        model.addAttribute("memVo", memVo);
        return "/login/welcome";
    }
}
