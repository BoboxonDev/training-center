package com.example.training.teacher;

import com.example.training.group.dto.GroupResponse;
import com.example.training.teacher.dto.TeacherRequest;
import com.example.training.teacher.dto.TeacherResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public void create(TeacherRequest request) {
        var teacher = teacherMapper.toEntity(request);
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setUpdatedAt(LocalDateTime.now());
        teacherRepository.save(teacher);
    }

    @Override
    public List<TeacherResponse> getAll() {
        var teachers = teacherRepository.findAllByDeleteAtIsNull();
        List<TeacherResponse> list = new ArrayList<>();

        teachers.forEach(teacher -> {
            var dto = teacherMapper.toDto(teacher);

            dto.setGroupId(teacher.getGroup().getId());
            var t = new GroupResponse();
            t.setId(teacher.getGroup().getId());
            t.setGroupName(teacher.getGroup().getGroupName());
            dto.setGroupResponse(t);
            list.add(dto);
        });
        return list;
    }

    @Override
    public TeacherResponse getById(Long id) {
        var entity  = teacherRepository.findById(id).orElseThrow();
        var dto = teacherMapper.toDto(entity);
        return dto;
    }

    @Override
    public void updateTeacher(TeacherRequest id) {

    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest request) {
        var entity = teacherRepository.findById(id).orElseThrow();
        entity.setFullName(request.getFullName());
        entity.setSubject(request.getSubject());
        entity.setExperience(request.getExperience());

        var updateEntity = teacherRepository.save(entity);
        var dto  = teacherMapper.toDto(updateEntity);
        return dto;
    }

    @Override
    public TeacherResponse deleteTeacherById(Long id) {
        var entity = teacherRepository.findById(id).orElseThrow();
        entity.setDeletedAt(LocalDateTime.now());
        var dto = teacherMapper.toDto(entity);
        teacherRepository.save(entity);
        return dto;
    }
}
