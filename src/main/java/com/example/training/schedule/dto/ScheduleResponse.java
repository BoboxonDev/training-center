package com.example.training.schedule.dto;

import com.example.training.group.dto.GroupResponse;
import com.example.training.price.dto.PriceResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {

    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;

    private LocalTime enTime;


    @NotNull
    private Long groupId;

    private GroupResponse groupResponse;
}
