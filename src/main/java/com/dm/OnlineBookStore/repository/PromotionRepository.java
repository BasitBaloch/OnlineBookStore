package com.dm.OnlineBookStore.repository;

import com.dm.OnlineBookStore.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findByType(String type);
}
