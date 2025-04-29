package com.example.training.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("select s from PriceEntity as s where s.group.id in :groupId")
    List<PriceEntity> findAllByGroupId(Long groupId);

    List<PriceEntity> findAllByDeleteAtIsNull();
}
