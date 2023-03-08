package com.example.selfstudy.dao;

import com.example.selfstudy.vo.Vo_study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudyDao {

    // 공부 기록 전체리스트
    public List<Vo_study> doStudyList();

    // 공부 기록 단일 리스트
    public Vo_study doStudyListOne(String strId);

    // 공부 기록 수정(업데이트)
    public int doStudyUp(Vo_study vo_study);

    // 공부하기 삭제
    public int doStudyDel(Long id);

    // 공부하기 등록
    public void doStudyIns(Vo_study vo_study);
}
