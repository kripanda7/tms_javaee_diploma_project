package by.teachmeskills.carparts.controller;

import by.teachmeskills.carparts.config.security.JwtHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    public static final String AUTH_REQUEST_MAPPING = "/auth";
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final JwtHelper jwtHelper;

    @GetMapping(AUTH_REQUEST_MAPPING)
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password,
                                        @RequestHeader(required = false, value = "X-Source") String source) {
        try {
            UsernamePasswordAuthenticationToken authenticate = (UsernamePasswordAuthenticationToken) daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(login, password));
            return ResponseEntity.ok(jwtHelper.generateToken(
                    AuthController.class.getSimpleName(),
                    source,
                    authenticate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
