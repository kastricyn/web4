package ru.kastricyn.web4.controller;

import org.apache.catalina.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.dto.TokenDto;
import ru.kastricyn.web4.dto.UserDto;
import ru.kastricyn.web4.service.AuthService;
import ru.kastricyn.web4.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final AuthService authService;
    private final UserService userService;

    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenDto login(@RequestBody @Valid UserDto.In user) {
        return authService.login(user);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto.Out registration(@RequestBody @Valid UserDto.In user) {
        return authService.register(user);
    }

    @PostMapping(value = "/loginWithRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public TokenDto loginWithRegistration(@RequestBody @Valid UserDto.In user) {
        UserDto.In cloneUser =  user.clone();
        if (!userService.existUserEntity(user.getLogin()))
            authService.register(user);
        return authService.login(cloneUser);
    }

}
