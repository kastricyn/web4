package ru.kastricyn.web4.service;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.entity.User;

@Service
public class MyUserService implements UserService {

    /**
     * Пытается авторизовать.
     *
     * @param user
     * @return true -- успешная авторизация; false -- неуспешная
     */
    @Override
    public boolean auth(User user) {
        return false;
    }

    /**
     * Пытается зарегистрировать.
     *
     * @param user
     * @return true -- успешная регистрация; false -- неуспешная
     */
    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }
}
