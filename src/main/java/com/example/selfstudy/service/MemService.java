package com.example.selfstudy.service;

import com.example.selfstudy.vo.MemVo;

public interface MemService {

    // 회원 번호 만들기
    String createMemberNumber();

    // 회원가입(저장)
    int joinMembership(MemVo memVo);
}
