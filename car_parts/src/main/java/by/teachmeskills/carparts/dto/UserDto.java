package by.teachmeskills.carparts.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String status;
    private String login;
    private String password;
    private Long phone;
    private String email;
    private String address;
}
