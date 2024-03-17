package by.teachmeskills.carparts.service;

import by.teachmeskills.carparts.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
}
