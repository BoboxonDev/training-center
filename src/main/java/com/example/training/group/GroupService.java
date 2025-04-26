package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;

import java.util.List;

public interface GroupService {

    void create(GroupRequest request);

    List<GroupResponse> getAll();

    GroupResponse getById(Long id);

    void updateGroup(GroupRequest id);

    GroupResponse updateGroup(Long id, GroupRequest request);

    GroupResponse deleteGroupById(Long id);

}
