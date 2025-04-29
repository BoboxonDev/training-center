package com.example.training.price.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {

    private Integer amount;

    @NotNull
    private Long groupId;

}
