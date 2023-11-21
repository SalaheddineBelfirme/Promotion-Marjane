package com.youcode.repositories;

import com.youcode.entities.CenterAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CenterAdministratorRepository extends JpaRepository<CenterAdministrator, UUID> {
    Optional<CenterAdministrator>findByEmailAndPassword(String email,String password);
}
