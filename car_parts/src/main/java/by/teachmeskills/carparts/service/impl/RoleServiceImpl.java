package by.teachmeskills.carparts.service.impl;

import by.teachmeskills.carparts.entity.Role;
import by.teachmeskills.carparts.repository.RoleRepository;
import by.teachmeskills.carparts.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}