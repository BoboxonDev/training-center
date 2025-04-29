package com.example.training.price.dto;

import com.example.training.group.GroupEntity;
import com.example.training.group.dto.GroupResponse;
import com.example.training.teacher.dto.TeacherResponse;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse {

    private Long id;

    private Integer amount;

    @NotNull
    private Long groupId;

    private GroupResponse groupResponse;


}
