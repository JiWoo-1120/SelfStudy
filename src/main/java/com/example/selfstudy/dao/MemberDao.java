package com.example.selfstudy.dao;


import com.example.selfstudy.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {

    // 멤버 리스트 전체 출력
    public List<MemberVo> memberList();

    // 멤버 등록
    public void save(MemberVo memberVo);

    // 멤버 수정
    public void update(MemberVo memberVo);

    // 멤버 한개 리스트 출력(수정페이지)
    public MemberVo memberListOne(int memberId);

    // 멤버 삭제
    void delete(int memberId);
}
