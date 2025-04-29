package com.example.training.teacher;

import com.example.training.group.GroupEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "teachers")
@Builder
@Data
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "experience")
    private Integer experience;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;



    @OneToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    public TeacherEntity() {

    }
}
