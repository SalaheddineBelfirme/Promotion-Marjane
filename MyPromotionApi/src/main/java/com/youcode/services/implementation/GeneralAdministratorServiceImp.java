package com.youcode.services.implementation;

import com.youcode.entities.GeneralAdministrator;
import com.youcode.repositories.GeneralAdministratorRepository;
import com.youcode.services.AdministratorLogin;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralAdministratorServiceImp implements AdministratorLogin<GeneralAdministrator> {
    private GeneralAdministratorRepository repository;

    public GeneralAdministratorServiceImp(GeneralAdministratorRepository generalAdministratorRepository) {
        this.repository = generalAdministratorRepository;
    }

    @Override
    public Optional<GeneralAdministrator> login(GeneralAdministrator o) {
        return Optional.empty();
    }
}
