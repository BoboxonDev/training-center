package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface GroupMapper {

    GroupEntity toEntity(GroupRequest request);

    GroupResponse toDto(GroupEntity entity);

}
