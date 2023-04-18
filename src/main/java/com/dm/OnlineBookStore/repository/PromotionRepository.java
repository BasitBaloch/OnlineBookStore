package com.dm.OnlineBookStore.repository;

import com.dm.OnlineBookStore.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByPromotionCode(String code);
}
