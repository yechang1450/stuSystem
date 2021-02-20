package com.heaboy.service.course.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassNameVo implements Serializable {

    //课程号
    String courseNo;
    //课程名称
    String courseName;
}
