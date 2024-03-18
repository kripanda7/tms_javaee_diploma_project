package by.teachmeskills.carparts.mapper;

import by.teachmeskills.carparts.dto.UserDto;
import by.teachmeskills.carparts.entity.User;
import by.teachmeskills.carparts.service.RoleService;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(target = "role", ignore = true)
    User toEntity(UserDto user, @Context RoleService roleService, @Context PasswordEncoder passwordEncoder);

    @Mapping(target = "role", ignore = true)
    UserDto toDto(User user);

    @AfterMapping
    default void postConstruct(UserDto userDto, @MappingTarget User user,
                               @Context RoleService roleService, @Context PasswordEncoder passwordEncoder) {
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        roleService.findByName(userDto.getRole()).ifPresent(user::setRole);
    }
}
