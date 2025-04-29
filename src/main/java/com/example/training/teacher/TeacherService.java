package com.example.training.teacher;

import com.example.training.teacher.dto.TeacherRequest;
import com.example.training.teacher.dto.TeacherResponse;

import java.util.List;

public interface TeacherService {

    void    create(TeacherRequest request);

    List<TeacherResponse> getAll();

    TeacherResponse getById(Long id);

    void updateTeacher(TeacherRequest id);

    TeacherResponse updateTeacher(Long id, TeacherRequest request);

    TeacherResponse deleteTeacherById(Long id);
}
