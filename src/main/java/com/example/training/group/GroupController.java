package com.example.training.group;

import com.example.training.group.dto.GroupRequest;
import com.example.training.group.dto.GroupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    ResponseEntity<Void> createGroup(@RequestBody GroupRequest request){
        groupService.create(request);
        return null;
    }

    @GetMapping
    ResponseEntity<List<GroupResponse>> getAllGroup() {return ResponseEntity.ok(groupService.getAll());}


    @GetMapping("{id}")
    ResponseEntity<GroupResponse> getById(@PathVariable Long id) { return ResponseEntity.ok(groupService.getById(id));}

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody GroupRequest request, @PathVariable Long id) {
        groupService.updateGroup(id, request);
        return null;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return null;
    }

}
