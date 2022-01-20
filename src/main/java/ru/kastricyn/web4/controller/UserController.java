package ru.kastricyn.web4.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.entity.User;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
     * @param user
     * @return true -- успешная авторизация; false -- неуспешная
     */
    @PostMapping("/auth")
    public boolean auth(User user) {
        return false;
    }

    /**
     * Пытается зарегистрировать.
     *
     * @param user
     * @return true -- успешная регистрация; false -- неуспешная
     */
    @PostMapping("/add")
    boolean register(User user) {
        return false;
    }

    @PostMapping("")
    boolean logout(User user) {
        return false;
    }

    @RequestMapping()
    public Principal user(Principal user) {
        return user;
    }
}
