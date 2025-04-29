package com.example.training.teacher;

import com.example.training.price.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {

    @Query("select s from TeacherEntity as s where s.group.id in :groupId")
    List<TeacherEntity> findAllByGroupId(Long groupId);
    List<TeacherEntity> findAllByDeleteAtIsNull();
}
