package com.example.training.schedule;

import com.example.training.schedule.dto.ScheduleRequest;
import com.example.training.schedule.dto.ScheduleResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, ScheduleMapper scheduleMapper) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public void create(ScheduleRequest request) {
        var schedule = scheduleMapper.toEntity(request);
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setUpdatedAt(LocalDateTime.now());
        scheduleRepository.save(schedule);
    }

    @Override
    public List<ScheduleResponse> getAll() {
        var schedules = scheduleRepository.findAllByDeleteAtIsNull();
        List<ScheduleResponse> list = new ArrayList<>();

        schedules.forEach(schedule -> {
            var dto = scheduleMapper.toDto(schedule);
            list.add(dto);
        });
        return list;
    }

    @Override
    public ScheduleResponse getById(Long id) {
        var schedule = scheduleRepository.findById(id).orElseThrow();
        var dto = scheduleMapper.toDto(schedule);
        return dto;

    }

    @Override
    public void updateSchedule(ScheduleRequest id) {

    }

    @Override
    public ScheduleResponse updateSchedule(Long id, ScheduleRequest request) {
        var schedule = scheduleRepository.findById(id).orElseThrow();
        schedule.setDayOfWeek(request.getDayOfWeek());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEnTime());

        var updateEntity = scheduleRepository.save(schedule);

        var dto = scheduleMapper.toDto(updateEntity);
        return dto;
    }

    @Override
    public ScheduleResponse deleteScheduleById(Long id) {
        var schedule = scheduleRepository.findById(id).orElseThrow();
        schedule.setDeletedAt(LocalDateTime.now());
        var dto = scheduleMapper.toDto(schedule);
        scheduleRepository.save(schedule);
        return dto;
    }
}
