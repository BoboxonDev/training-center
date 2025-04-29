package com.example.training.teacher.dto;

import com.example.training.group.dto.GroupResponse;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {

    private String fullName;

    private String subject;

    private Integer experience;

    @NotNull
    private Long groupId;


}
