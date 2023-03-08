package com.example.selfstudy.service;

import com.example.selfstudy.dao.StudyDao;
import com.example.selfstudy.vo.Vo_study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudyService {

    @Autowired
    StudyDao studyDao;

    /* 공부일지 전체 리스트 */
    public List<Vo_study> doStudyList(){

        List<Vo_study> list = new ArrayList<>();
        list = studyDao.doStudyList();

        return list;
    }

    /* 공부일지 단일 리스트 */
    public Vo_study doStudyListOne(String strId){

        Vo_study vo_study = new Vo_study();
        vo_study = studyDao.doStudyListOne(strId);

        return vo_study;
    };

    /* 공부일지 수정 */
    public int doStudyUp(Vo_study vo_study) {

        int intI = studyDao.doStudyUp(vo_study);

        return intI;
    }

    /* 공부일지 삭제 */
    public void doStudyDel(Long id) {
       studyDao.doStudyDel(id);
    }

    public void doStudyIns(Vo_study vo_study) {
        studyDao.doStudyIns(vo_study);
    }
}
