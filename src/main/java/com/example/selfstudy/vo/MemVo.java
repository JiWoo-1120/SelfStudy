package com.example.selfstudy.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemVo {
    private String memNo;
    private String memId;
    private String memPassword;
    private String memName;
    private String email;
    private String zipcode;
    private String baseAdres;
    private String detailAdres;
    private String phone;
    private String regDate;
    private String updateDate;
}
