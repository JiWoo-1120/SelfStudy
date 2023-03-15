package com.example.selfstudy.controller;

import com.example.selfstudy.service.MemService;
import com.example.selfstudy.service.imp.MemImp;
import com.example.selfstudy.vo.MemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/newMem")
public class MemControl {

    @Autowired
    private MemService memService;

    // id, email 중복, 유효성 검사
    @PostMapping("/memDataChk")
    @ResponseBody   // 메서드의 반환 값이 뷰로 해결되지 않고 HTTP 응답 본문으로 직접 직렬화되어야 함을 나타내기 위해 사용
    public Map<String, Object> idEmailCheck(@RequestBody MemVo memData){
        System.out.println("넘어온 데이터 memData => " + memData);
        Map<String, Object> data = new HashMap<String, Object>();

        data = memService.isContainValidation(memData);

        return data;
    }

    // 아이디, 이메일 중복 체크
//    @PostMapping("/idCheck")
//    @ResponseBody   // 메서드의 반환 값이 뷰로 해결되지 않고 HTTP 응답 본문으로 직접 직렬화되어야 함을 나타내기 위해 사용
//    public Map<Object, Object> idCheck(@RequestBody String memId){
//
//        int count = 0;
//        Map<Object, Object> data = new HashMap<Object, Object>();
//
//        // 중복 memId 확인
//        count = memService.idcheck(memId);
//        data.put("cnt", count);
//
//        return data;
//    }

    // 이메일 중복 체크
//    @PostMapping("/emailCheck")
//    @ResponseBody   // 메서드의 반환 값이 뷰로 해결되지 않고 HTTP 응답 본문으로 직접 직렬화되어야 함을 나타내기 위해 사용
//    public Map<Object, Object> emailCheck(@RequestBody String email){
//
//        int count = 0;
//        Map<Object, Object> data = new HashMap<Object, Object>();
//
//        // 중복 memId 확인
//        count = memService.emailCheck(email);
//        data.put("cnt", count);
//
//        return data;
//    }

    // SAVE(회원가입)
    @PostMapping("/insert")
    public String addMember(@ModelAttribute MemVo memVo, Model model) throws Exception {

        memVo.setMemPasswordSalt("00");

        // 회원번호 만들기
        String memNo = memService.createMemberNumber();
        System.out.println("컨틀롤러가 받은 memNo => " + memNo);
        memVo.setMemNo(memNo);
        // 가입날짜
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = dateTimeFormat.format(now);
        memVo.setRegDate(nowTime);
        memVo.setUpdateDate(nowTime);

        // 유효성 검사
        String msg = null;
        int result = memService.saveMemberValidation(memVo);
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
