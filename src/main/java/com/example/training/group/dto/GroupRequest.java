package com.example.training.group.dto;

import com.example.training.teacher.dto.TeacherResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {

    private String groupName;

    private List<TeacherResponse> teachers;
    private List<TeacherResponse> prices;
    private List<TeacherResponse> schedules;

}
