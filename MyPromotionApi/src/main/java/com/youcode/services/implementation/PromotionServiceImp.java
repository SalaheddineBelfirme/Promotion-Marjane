package com.youcode.services.implementation;

import com.youcode.entities.ProductPromotion;
import com.youcode.entities.Promotion;
import com.youcode.repositories.PromotionRepository;
import com.youcode.services.IProductPromotion;
import com.youcode.services.PromotionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PromotionServiceImp implements IProductPromotion {
    private PromotionRepository repository;

    public PromotionServiceImp(PromotionRepository promotionRepository) {
        this.repository = promotionRepository;
    }

    @Override
    public Optional<ProductPromotion> create(ProductPromotion promotion) {
        return Optional.of(repository.save(promotion));
    }

    @Override
    public Optional<ProductPromotion> read(UUID uuid) {
        return repository.findById(uuid);

    }

    @Override
    public List<ProductPromotion> readAll() {
        List<ProductPromotion> productPromotions=new ArrayList<>();
         repository.findAll().forEach(productPromotion -> {
             productPromotions.add(productPromotion);
             System.out.println(productPromotion.getPercentage());
         });
         //return  productPromotions;
         return repository.findAll();
    }

    @Override
    public Optional<ProductPromotion> update(ProductPromotion promotion) {
         Optional<ProductPromotion> promotion1=repository.findById(promotion.getUuid());
         if (promotion1.isPresent()){
             ProductPromotion p=promotion1.get();
             p.setPercentage(promotion.getPercentage());
             return Optional.of(repository.save(p));
         }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID uuid) {

       try {
           repository.deleteById(uuid);
           return true;
       }catch (Exception e){
           System.out.println(e.getMessage());
           return  false;
       }
    }
}
