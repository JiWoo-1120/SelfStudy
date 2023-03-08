package com.example.selfstudy.service.imp;

import com.example.selfstudy.vo.MemVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MemImpTest {

    @Autowired
    MemImp memImp;


    @Test
    void joinMembership() {
        // 예상
        String memNo = "CU20230306A00001";
        String memId = "didwldn";
        String memPassword ="asd123456789!";
        String memName = "d테스트";
        String email = "ID2naver@naver.com";
        String zipcode = "12345";
        String baseAdres = "태양계 지구 한국";
        String detailAdres = "가산";
        String phone = "010--5678";
        String regDate = "2023-03-06 15:00:13";
        String updateDate = "2023-03-06 15:00:13";

        MemVo memVo = new MemVo(memNo, memId, memPassword, memName, email, zipcode, baseAdres, detailAdres, phone, regDate, updateDate);
        int result = memImp.joinMembership(memVo);

        // 기대
//
         int extend = 3;

        // 비교
        assertEquals(extend, result);
    }

    private void assertEquals(int extend, int result) {
    }


}