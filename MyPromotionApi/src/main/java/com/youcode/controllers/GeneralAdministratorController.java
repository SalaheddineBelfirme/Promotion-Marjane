package com.youcode.controllers;

import com.youcode.services.implementation.GeneralAdministratorServiceImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generalAdmin")
public class GeneralAdministratorController {
    private final GeneralAdministratorServiceImp service;

    public GeneralAdministratorController(GeneralAdministratorServiceImp generalAdministratorServiceImp) {
        this.service = generalAdministratorServiceImp;
    }
}
