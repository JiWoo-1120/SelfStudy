package com.example.selfstudy.service.imp;

import com.example.selfstudy.dao.MemDao;
import com.example.selfstudy.dao.MemberDao;
import com.example.selfstudy.service.MemService;
import com.example.selfstudy.vo.MemVo;
import com.example.selfstudy.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Service
public class MemImp implements MemService {

    @Autowired
    MemDao memDao;

    /* 회원번호 만들기 */
    @Override
    public String createMemberNumber() {
        String first = "CU"; //회원번호 첫번째
        String today = ""; // 오늘날짜
        String memNo = memDao.findMemNo(); // db에서 가장 최신의 데이터를 memNo에 넣어준다.

        LocalDate now = LocalDate.now(); // 현재 날짜 구하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // 포맷 정의
        today = now.format(formatter); // ex) 20230303

        if(memNo == null){
            memNo = first + today + "A00001";
        } else if(memNo != null){
            char abc = memNo.charAt(10);
            int num = Integer.parseInt(memNo.substring(11));
            System.out.println("잘린 숫자" + num);

            if(num >= 10000){
                abc = (char) (abc +  1);
                num = 1;
                String numOne = String.format("%05d", num);
                System.out.println("numOne 스트링으로 전환된 =>" + numOne);
                memNo = first + today + abc + numOne;
                System.out.println("알파벳이 증가해버렸지요~ =>" + memNo);
            } else if(num < 10000){
                num = num+1;
                String numPlus = String.format("%05d", num);
                memNo = first + today + abc + numPlus;
                System.out.println("숫자만 증가~ =>" + memNo);
            }
        }
        return memNo;
    }

    /* 회원가입(저장) */
    @Override
    public int joinMembership(MemVo memVo) {

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = dateTimeFormat.format(now);

        memVo.setRegDate(nowTime);
        memVo.setUpdateDate(nowTime);

        int result = 0;

        if (memVo == null){
            result = 1;
        } else if(!Pattern.matches("^[가-힣ㄱ-ㅎ]+$", memVo.getMemName())){
            result = 2;
        } else if(!(Pattern.matches("^(?=.*?[0-9])(?=.*?[A-Za-z])(?=.*?[#?!@$ %^&*~-]).{8,20}$", memVo.getMemPassword()))) {
            result = 3;
        } else if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", memVo.getEmail())){
            result = 4;
        } else if(!Pattern.matches("^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", memVo.getPhone())) {
            result = 5;
        }
        else {
            memDao.saveMem(memVo);
            result = 0;
        }
        return result;
    }
}



