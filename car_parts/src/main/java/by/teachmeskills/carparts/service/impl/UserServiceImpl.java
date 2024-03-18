package by.teachmeskills.carparts.service.impl;

import by.teachmeskills.carparts.dto.UserDto;
import by.teachmeskills.carparts.exception.NotFoundException;
import by.teachmeskills.carparts.mapper.UserMapper;
import by.teachmeskills.carparts.repository.UserRepository;
import by.teachmeskills.carparts.service.RoleService;
import by.teachmeskills.carparts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id {} not found.", id)));
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        userDto.setRole("USER");
        userDto.setStatus("OK");
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto, roleService, passwordEncoder)));
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        userRepository.findById(userDto.getId()).ifPresent(user -> {
            userMapper.partialUpdate(userDto, user);
            userRepository.save(user);
        });
        return getUserById(userDto.getId());
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
