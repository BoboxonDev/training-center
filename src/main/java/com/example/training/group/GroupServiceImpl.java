package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;
import com.example.training.price.PriceRepository;
import com.example.training.price.dto.PriceResponse;
import com.example.training.schedule.ScheduleRepository;
import com.example.training.schedule.dto.ScheduleResponse;
import com.example.training.teacher.TeacherRepository;
import com.example.training.teacher.dto.TeacherResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final TeacherRepository teacherRepository;
    private final PriceRepository priceRepository;
    private final ScheduleRepository scheduleRepository;
    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper, TeacherRepository teacherRepository, PriceRepository priceRepository, ScheduleRepository scheduleRepository) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.teacherRepository = teacherRepository;
        this.priceRepository = priceRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void create(GroupRequest request) {
        var group = groupMapper.toEntity(request);
        group.setCreatedAt(LocalDateTime.now());
        group.setUpdatedAt(LocalDateTime.now());
        groupRepository.save(group);
    }

    @Override
    public List<GroupResponse> getAll() {
        var groups = groupRepository.findAllByDeletedAtIsNull();
        List<GroupResponse> list = new ArrayList<>();

        groups.forEach(group -> {
            var dto = groupMapper.toDto(group);

            var teachers = teacherRepository.findAllByGroupId(group.getId());
            List<TeacherResponse> tlist = new ArrayList<>();
            if(teachers!=null) {
                teachers.forEach(tt -> {
                    var t = groupMapper.toResponse(tt);
                    tlist.add(t);
                });
            }
                var prices = priceRepository.findAllByGroupId(group.getId());
                List<PriceResponse> plist = new ArrayList<>();
                if(prices!=null) {
                    prices.forEach(pp -> {
                        var p = groupMapper.toRes(pp);
                        plist.add(p);
                    });
                }

                    var schedules = scheduleRepository.findAllByGroupId(group.getId());
                    List<ScheduleResponse> slist = new ArrayList<>();
                    if(schedules!=null){
                        schedules.forEach(ss -> {
                            var s = groupMapper.toResp(ss);
                            slist.add(s);
                        });
                    }


            dto.setTeachers(tlist);
            dto.setSchedules(slist);
            dto.setPrices(plist);
            list.add(dto);
        });
        return list;
    }

    @Override
    public GroupResponse getById(Long id) {
        var entity = groupRepository.findById(id).orElseThrow();
        var dto = groupMapper.toDto(entity);
        return dto;
    }

    @Override
    public void updateGroup(GroupRequest id) {

    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest request) {
        var entity = groupRepository.findById(id).orElseThrow();
        entity.setGroupName(request.getGroupName());

        var updateEntity = groupRepository.save(entity);

        var dto = groupMapper.toDto(updateEntity);
        return dto;
    }

    @Override
    public GroupResponse deleteGroupById(Long id) {
        var entity = groupRepository.findById(id).orElseThrow();
        entity.setDeletedAt(LocalDateTime.now());
        var dto = groupMapper.toDto(entity);
        groupRepository.save(entity);
        return dto;
    }
}
