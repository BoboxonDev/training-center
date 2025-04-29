package com.example.training.group.dto;

import com.example.training.price.dto.PriceResponse;
import com.example.training.schedule.dto.ScheduleResponse;
import com.example.training.teacher.dto.TeacherResponse;
import lombok.Data;

import java.util.List;

@Data
public class GroupResponse {

    private Long id;

    private String groupName;

    private List<TeacherResponse> teachers;
    private List<PriceResponse> prices;
    private List<ScheduleResponse> schedules;
}
