package com.youcode.services.implementation;

import com.youcode.entities.CenterAdministrator;
import com.youcode.repositories.CenterAdministratorRepository;
import com.youcode.services.AdministratorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CenterAdministratorServiceImp implements AdministratorService<CenterAdministrator> {
    private CenterAdministratorRepository repository;

    public CenterAdministratorServiceImp(CenterAdministratorRepository centerAdministratorRepository) {
        this.repository = centerAdministratorRepository;
    }

    @Override
    public Optional<CenterAdministrator> login(CenterAdministrator o) {

        return repository.findByEmailAndPassword(o.getEmail(),String.valueOf(o.getPassword().hashCode()));
    }

    @Override
    public Optional<CenterAdministrator> create(CenterAdministrator o) {
        o.setPassword(String.valueOf(o.getPassword().hashCode()));
        return  Optional.of( repository.save(o));
    }

    @Override
    public boolean delete(UUID uuid) {
        try {
        repository.deleteById(uuid);
        return true;
        }catch (Exception e){
            return false;
        }

    }
}
