package com.example.training.teacher;


import com.example.training.teacher.dto.TeacherRequest;
import com.example.training.teacher.dto.TeacherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    ResponseEntity<Void> createTeacher( @RequestBody TeacherRequest request){
        teacherService.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<TeacherResponse>> getTeachers() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<TeacherResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@RequestBody TeacherRequest request, @PathVariable Long id) {
        teacherService.updateTeacher(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok().build();
    }

}
