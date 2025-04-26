package com.example.training.schedule;

import com.example.training.schedule.dto.ScheduleRequest;
import com.example.training.schedule.dto.ScheduleResponse;

import java.util.List;

public interface ScheduleService {

    void create(ScheduleRequest request);

    List<ScheduleResponse> getAll();

    ScheduleResponse getById(Long id);

    void updateSchedule(ScheduleRequest id);

    ScheduleResponse updateSchedule(Long id, ScheduleRequest request);

    ScheduleResponse deleteScheduleById(Long id);

}
