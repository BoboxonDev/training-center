package com.example.training.schedule;

import com.example.training.price.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    @Query("select s from ScheduleEntity as s where s.group.id in :groupId")
    List<ScheduleEntity> findAllByGroupId(Long groupId);
    List<ScheduleEntity> findAllByDeleteAtIsNull();
}
