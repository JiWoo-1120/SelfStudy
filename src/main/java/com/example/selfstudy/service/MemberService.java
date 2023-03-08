package com.example.selfstudy.service;

import com.example.selfstudy.dao.MemberDao;
import com.example.selfstudy.vo.MemberVo;
import com.example.selfstudy.vo.Vo_study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public List<MemberVo> doMemberList() {

        List<MemberVo> list = new ArrayList<>();
        list = memberDao.memberList();

        return list;
    }


    public void memberInsert(MemberVo memberVo) {
        memberDao.save(memberVo);

    }

    public void memberMod(MemberVo memberVo) {

       memberDao.update(memberVo);

    }

    public MemberVo memberListOne(int memberId) {

        MemberVo list = memberDao.memberListOne(memberId);

        return list;
    }

    public void memberDel(int memberId) {
        memberDao.delete(memberId);

    }
}
