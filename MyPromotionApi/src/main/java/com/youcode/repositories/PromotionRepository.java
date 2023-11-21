package com.youcode.repositories;

import com.youcode.entities.ProductPromotion;
import com.youcode.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromotionRepository extends JpaRepository<ProductPromotion, UUID> {

}
