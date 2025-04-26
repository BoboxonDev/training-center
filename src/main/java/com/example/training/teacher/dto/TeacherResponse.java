package com.example.training.teacher.dto;


import lombok.Data;

@Data
public class TeacherResponse {

    private Long id;

    private String fullName;

    private String subject;

    private Integer experience;
}
