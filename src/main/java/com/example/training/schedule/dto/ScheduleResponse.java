package com.example.training.schedule.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;


@Data
public class ScheduleResponse {

    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;

    private LocalTime enTime;
}
