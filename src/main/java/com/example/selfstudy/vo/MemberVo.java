package com.example.selfstudy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVo {
    private int memberId;
    private String loginId;
    private String password;
    private String name;
    private String role;
    private Date regDay;
}


