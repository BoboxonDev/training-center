package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;
import com.example.training.price.PriceEntity;
import com.example.training.price.dto.PriceResponse;
import com.example.training.schedule.ScheduleEntity;
import com.example.training.schedule.dto.ScheduleResponse;
import com.example.training.teacher.TeacherEntity;
import com.example.training.teacher.dto.TeacherResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface GroupMapper {

    GroupEntity toEntity(GroupRequest request);

    GroupResponse toDto(GroupEntity entity);

    TeacherResponse toResponse(TeacherEntity tt);

    PriceResponse toRes(PriceEntity pp);

    ScheduleResponse toResp(ScheduleEntity ss);

}
