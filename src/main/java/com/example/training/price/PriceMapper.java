package com.example.training.price;

import com.example.training.price.dto.PriceRequest;
import com.example.training.price.dto.PriceResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PriceMapper {

    PriceEntity toEntity(PriceRequest request);
    PriceResponse toDto(PriceEntity entity);
}
