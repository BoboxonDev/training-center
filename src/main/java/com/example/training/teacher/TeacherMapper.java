package com.example.training.teacher;


import com.example.training.teacher.dto.TeacherRequest;
import com.example.training.teacher.dto.TeacherResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TeacherMapper {

    TeacherEntity toEntity(TeacherRequest request);

    TeacherResponse toDto(TeacherEntity entity);
}
