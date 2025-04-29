package com.example.training.teacher.dto;


import com.example.training.group.dto.GroupResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeacherResponse {

    private Long id;

    private String fullName;

    private String subject;

    private Integer experience;

    @NotNull
    private Long groupId;

    private GroupResponse groupResponse;
}
