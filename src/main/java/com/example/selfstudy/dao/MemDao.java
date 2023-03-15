package com.example.selfstudy.dao;

import com.example.selfstudy.vo.MemVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemDao {

    // 가장 최신의 회원번호 가지고오기
    public String findMemNo();

    // 회원정보 저장
    void saveMem(MemVo memVo);

    // 중복 memId 확인
    int findId(String memId);

    // 중복 이메일 확인
    int findEmail(String email);

}
