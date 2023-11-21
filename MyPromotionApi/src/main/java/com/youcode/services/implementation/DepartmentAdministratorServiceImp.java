package com.youcode.services.implementation;

import com.youcode.entities.DepartmentAdministrator;
import com.youcode.repositories.DepartmentAdministratorRepository;
import com.youcode.services.AdministratorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentAdministratorServiceImp implements AdministratorService<DepartmentAdministrator> {
    private DepartmentAdministratorRepository repository;

    public DepartmentAdministratorServiceImp(DepartmentAdministratorRepository departmentAdministratorRepository) {
        this.repository = departmentAdministratorRepository;
    }

    @Override
    public Optional<DepartmentAdministrator> login(DepartmentAdministrator o) {
       return repository.findByEmailAndPassword(o.getEmail(),String.valueOf(o.getPassword().hashCode()));

    }

    @Override
    public Optional<DepartmentAdministrator> create(DepartmentAdministrator o) {
        o.setPassword(String.valueOf(o.getPassword().hashCode()));
        return Optional.of( repository.save(o));
    }

    @Override
    public boolean delete(UUID uuid) {
        try {
            repository.deleteById(uuid);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }



    }
}
