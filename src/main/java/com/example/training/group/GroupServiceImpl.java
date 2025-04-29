package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void create(GroupRequest request) {

    }

    @Override
    public List<GroupResponse> getAll() {
        return null;
    }

    @Override
    public GroupResponse getById(Long id) {
        return null;
    }

    @Override
    public void updateGroup(GroupRequest id) {

    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest request) {
        return null;
    }

    @Override
    public GroupResponse deleteGroupById(Long id) {
        return null;
    }
}
