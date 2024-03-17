package by.teachmeskills.carparts.service;

import by.teachmeskills.carparts.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long id);

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
