package com.youcode.services;

import java.util.Optional;
import java.util.UUID;

// Will be implemented by CenterAdministrator and DepartmentAdministrator
public interface AdministratorService<O> extends AdministratorLogin<O> {
    Optional<O> create(O o);
    boolean delete(UUID uuid);
}
