package com.youcode.controllers;

import com.youcode.entities.DepartmentAdministrator;
import com.youcode.services.implementation.CenterAdministratorServiceImp;
import com.youcode.services.implementation.DepartmentAdministratorServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/departmentAdmin")
public class DepartmentAdministratorController {
    private DepartmentAdministratorServiceImp service;

    public DepartmentAdministratorController(DepartmentAdministratorServiceImp departmentAdministratorServiceImp) {
        this.service = departmentAdministratorServiceImp;
    }



    @PostMapping
    public ResponseEntity<String> createDepartmentAdmin(@RequestBody DepartmentAdministrator departmentAdministrator) {
        if (service.create(departmentAdministrator).isPresent()) {
            return new ResponseEntity<>("Department Administrator created with successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Department Administrator creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentAdmin(@PathVariable UUID id) {
        if (service.delete(id)) {
            return new ResponseEntity<>("Department Administrator deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Department Administrator deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/login")
    public ResponseEntity<String>readDepartmentAdministrator (@RequestBody DepartmentAdministrator departmentAdministrator) {
        System.out.println(departmentAdministrator.getEmail());
        if (service.login(departmentAdministrator).isPresent()){
            System.out.println(service.login(departmentAdministrator).toString());
            return  new ResponseEntity<>("don",HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("try agne ",HttpStatus.INTERNAL_SERVER_ERROR);

    }








}
