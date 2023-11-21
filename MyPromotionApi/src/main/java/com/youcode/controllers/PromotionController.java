package com.youcode.controllers;

import com.youcode.entities.ProductPromotion;
import com.youcode.entities.Promotion;
import com.youcode.services.PromotionService;
import com.youcode.services.implementation.PromotionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {
    private final PromotionServiceImp service;
    @Autowired
    public PromotionController(PromotionServiceImp promotionService) {
        this.service = promotionService;
    }

    @GetMapping("/{uuid}")
    public void readPromotion(@PathVariable UUID uuid){

        System.out.println("from readPromotion "+uuid);
    }
    @PostMapping
    public ResponseEntity<String> createPromotion(@RequestBody ProductPromotion productPromotion) {
        System.out.println(productPromotion.getPercentage());
        if (service.create(productPromotion).isPresent()){
            return new ResponseEntity<>("product Promotion added ",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("try again ",HttpStatus.INTERNAL_SERVER_ERROR);



    }


@GetMapping
    public ResponseEntity<List<ProductPromotion>> readProductPromotion() {
    System.out.println("method readDepartmentAdministrator mapped");
    List<ProductPromotion> allPromotions=service.readAll();
    if (!allPromotions.isEmpty()) {
        return new ResponseEntity<>(allPromotions, HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
    @PutMapping
    public ResponseEntity<ProductPromotion>  updateProductPromotion(@RequestBody ProductPromotion productPromotion){
        return  service.create(productPromotion).map(updatPromtion->new ResponseEntity<>(updatPromtion,HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String>deleteProductPromotion(@PathVariable UUID uuid){
        if(service.delete(uuid)){
            return new ResponseEntity<>("Product Promotion is delated",HttpStatus.OK);

        }
        return new ResponseEntity<>("try agin",HttpStatus.OK);

    }




}
