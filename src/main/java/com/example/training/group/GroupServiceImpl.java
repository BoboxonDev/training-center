package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
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
        var groups = groupRepository.findAllByDeleteAtIsNull();
        List<GroupResponse> list = new ArrayList<>();

        groups.forEach(group -> {
            var dto = groupMapper.toDto(group);

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
