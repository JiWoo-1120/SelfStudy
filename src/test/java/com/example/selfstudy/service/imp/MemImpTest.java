package com.example.selfstudy.service.imp;

import com.example.selfstudy.dao.MemDao;
import com.example.selfstudy.vo.MemVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@SpringBootTest
class MemImpTest {

    @Autowired
    MemImp memImp;

    @Autowired
    MemDao memDao;

    String memNo = "CU20230306A00001";
    String memId = "didwldn";
    String memPassword ="asd123456789!";
    String memPasswordSalt ="W715GvOpBXSCYSxoScN2/Q==";
    String memName = "d테스트";
    String email = null;
    String zipcode = "12345";
    String baseAdres = "태양계 지구 한국";
    String detailAdres = "가산";
    String phone = "0105678";
    String regDate = "2023-03-06 15:00:13";
    String updateDate = "2023-03-06 15:00:13";

    MemVo memVo = new MemVo(memNo, memId, memPassword, memPasswordSalt, memName, email, zipcode, baseAdres, detailAdres, phone, regDate, updateDate);

//    @DisplayName("회원정보 저장 테스트")
//    @Test
//    void joinMembership() {
//        // 예상
//        String memNo = "CU20230306A00001";
//        String memId = "didwldn";
//        String memPassword ="asd123456789!";
//        String memPasswordSalt ="asd123456789!";
//        String memName = "d테스트";
//        String email = "ID2naver@naver.com";
//        String zipcode = "12345";
//        String baseAdres = "태양계 지구 한국";
//        String detailAdres = "가산";
//        String phone = "010--5678";
//        String regDate = "2023-03-06 15:00:13";
//        String updateDate = "2023-03-06 15:00:13";
//
//        MemVo memVo = new MemVo(memNo, memId, memPassword, memPasswordSalt, memName, email, zipcode, baseAdres, detailAdres, phone, regDate, updateDate);
//
//        // 기대
////
//         int extend = 3;
//
//        // 비교
//    }

    private void assertEquals(int extend, int result) {
    }

    @DisplayName("AES 암호화 테스트")
    @Test
    void encryption() throws Exception {

        // 예상
        MemVo memVoResult = memImp.encryptionAES(memVo);

        String pw = memVoResult.getMemPassword();
        String phone1 = memVoResult.getPhone();

        System.out.println("pw => " + pw);
        System.out.println("phone => " + phone1);

    }

    @Test
    void encryptionSHA() throws NoSuchAlgorithmException {

        memImp.encryptionSHA(memVo);

    }

    @DisplayName("아이디, 이메일 중복검사 체크")
    @Test
    void isContainValidation() {

        // 예상
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("result", "SUCCESS");

        // 실제
        memImp.isContainValidation(memVo);

    }
}