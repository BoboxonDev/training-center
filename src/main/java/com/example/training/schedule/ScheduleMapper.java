package com.example.training.schedule;

import com.example.training.schedule.dto.ScheduleRequest;
import com.example.training.schedule.dto.ScheduleResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ScheduleMapper {

    ScheduleEntity toEntity(ScheduleRequest request);

    ScheduleResponse toDto(ScheduleEntity entity);
}
