package com.example.training.schedule;


import com.example.training.group.GroupEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@Builder
@Data
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dayOfWeek")
    private DayOfWeek dayOfWeek;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    public ScheduleEntity() {

    }

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    @OneToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}
