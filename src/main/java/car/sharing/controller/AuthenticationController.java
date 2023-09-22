package car.sharing.controller;

import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import car.sharing.dto.request.UserLoginDto;
import car.sharing.dto.request.UserRegistrationDto;
import car.sharing.dto.response.UserResponseDto;
import car.sharing.entity.User;
import car.sharing.exception.AuthenticationException;
import car.sharing.mapper.UserMapper;
import car.sharing.security.AuthenticationService;
import car.sharing.security.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    @Operation(summary = "Data for registration", description = "Data for registration")
    @PostMapping("/register")
    public UserResponseDto register(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        User user = authenticationService.register(userMapper.mapToEntity(userRegistrationDto));
        return userMapper.mapToDto(user);
    }

    @Operation(summary = "Data for login", description = "Data for login")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user =
                authenticationService.login(userLoginDto.getEmail(), userLoginDto.getPassword());
        String token =
                jwtTokenProvider.createToken(user.getEmail(), List.of(user.getRole().name()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}

