package com.example.training.schedule;

import com.example.training.schedule.dto.ScheduleRequest;
import com.example.training.schedule.dto.ScheduleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    ResponseEntity<Void> createSchedule(@RequestBody ScheduleRequest request){
        scheduleService.create(request);
        return null;
    }

    @GetMapping
    ResponseEntity<List<ScheduleResponse>> getAll() {return ResponseEntity.ok(scheduleService.getAll());}

    @GetMapping("{id}")
    ResponseEntity<ScheduleResponse> getById(@PathVariable Long id) {return ResponseEntity.ok(scheduleService.getById(id));}

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody ScheduleRequest request, @PathVariable Long id) {
        scheduleService.updateSchedule(id, request);
        return null;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return null;
    }
}
