package com.example.selfstudy.dao;

import com.example.selfstudy.vo.MemVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemDao {

    // 가장 최신의 회원번호 가지고오기
    public String findMemNo();

    // 회원정보 저장
    void saveMem(MemVo memVo);


}
