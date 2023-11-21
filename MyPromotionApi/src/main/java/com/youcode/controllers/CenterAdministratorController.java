package com.youcode.controllers;

import com.youcode.entities.CenterAdministrator;
import com.youcode.services.implementation.CenterAdministratorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/centerAdministrator")
public class CenterAdministratorController {
    private CenterAdministratorServiceImp service;

    @Autowired
    public CenterAdministratorController(CenterAdministratorServiceImp centerAdministratorServiceImp) {
        this.service = centerAdministratorServiceImp;
    }

  @PostMapping
    public ResponseEntity<String> CerateCenterAdministrator(@RequestBody CenterAdministrator centerAdministrator){
         if(service.create(centerAdministrator).isPresent()){
             return new ResponseEntity<>("Center Administrator created with successfully", HttpStatus.CREATED);

         }
             return new ResponseEntity<>("something was wrong when create center Administrator ", HttpStatus.INTERNAL_SERVER_ERROR);


  }
  @DeleteMapping("/{uuid}")
    public  ResponseEntity<String>deleteCenterAdministratorController(@PathVariable UUID uuid){
        if (service.delete(uuid)){
            return new ResponseEntity<>("Center Administrator deleted successfully", HttpStatus.OK);
        }
      return new ResponseEntity<>("Center Administrator deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);

  }

  @GetMapping(  "/login")
    public ResponseEntity<String>login(@RequestBody CenterAdministrator centerAdministrator){
        if (service.login(centerAdministrator).isPresent()){
            return new ResponseEntity<>("Department Administrator login with successfully", HttpStatus.OK);
        }
      return new ResponseEntity<>("Department Administrator login failed", HttpStatus.INTERNAL_SERVER_ERROR);

  }
}
