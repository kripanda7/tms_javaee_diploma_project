package by.teachmeskills.carparts.mapper;

import by.teachmeskills.carparts.dto.UserDto;
import by.teachmeskills.carparts.entity.Status;
import by.teachmeskills.carparts.entity.User;
import by.teachmeskills.carparts.service.RoleService;
import javax.annotation.processing.Generated;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-17T12:55:13+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto user, RoleService roleService, PasswordEncoder passwordEncoder) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setId( user.getId() );
        user1.setFirstName( user.getFirstName() );
        user1.setLastName( user.getLastName() );
        user1.setLogin( user.getLogin() );
        user1.setPassword( user.getPassword() );
        if ( user.getStatus() != null ) {
            user1.setStatus( Enum.valueOf( Status.class, user.getStatus() ) );
        }
        user1.setPhone( user.getPhone() );
        user1.setEmail( user.getEmail() );
        user1.setAddress( user.getAddress() );

        postConstruct( user, user1, roleService, passwordEncoder );

        return user1;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        if ( user.getStatus() != null ) {
            userDto.setStatus( user.getStatus().name() );
        }
        userDto.setLogin( user.getLogin() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhone( user.getPhone() );
        userDto.setEmail( user.getEmail() );
        userDto.setAddress( user.getAddress() );

        return userDto;
    }
}
