package ru.kastricyn.web4.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.entity.UserEntity;

import java.security.Principal;

@RestController
@RequestMapping("/api/users")
public class UserController {
    /**
     * Проверяет есть ли уже в системе пользователь с таким userName
     * @param userName
     * @return
     */
    @GetMapping("/{userName}")
    public boolean haveUser(@PathVariable() String userName){
        return false;
    }

    /**
     * Пытается авторизовать.
     *
     * @param userEntity
     * @return true -- успешная авторизация; false -- неуспешная
     */
    @PostMapping("/auth")
    public boolean auth(UserEntity userEntity) {
        return false;
    }

    /**
     * Пытается зарегистрировать.
     *
     * @param userEntity
     * @return true -- успешная регистрация; false -- неуспешная
     */
    @PostMapping("/add")
    boolean register(UserEntity userEntity) {
        return false;
    }

    @PostMapping("")
    boolean logout(UserEntity userEntity) {
        return false;
    }

    @RequestMapping()
    public Principal user(Principal user) {
        return user;
    }
}
