package com.example.training.price.dto;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class PriceRequest {

    private Integer amount;

}
