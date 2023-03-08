package com.example.selfstudy.vo;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vo_study {

    private Long id;
    private String studyDay;
    private String contents;
    private String regDay;

}
