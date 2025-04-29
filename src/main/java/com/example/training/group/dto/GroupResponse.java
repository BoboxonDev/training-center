package com.example.training.group.dto;

import com.example.training.teacher.dto.TeacherResponse;
import lombok.Data;

import java.util.List;

@Data
public class GroupResponse {

    private Long id;

    private String groupName;

    private List<TeacherResponse> teachers;
    private List<TeacherResponse> prices;
    private List<TeacherResponse> schedules;
}
