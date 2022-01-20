package ru.kastricyn.web4.service;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.entity.UserEntity;

@Service
public class MyUserService implements UserService {

    /**
     * Пытается авторизовать.
     *
     * @param userEntity
     * @return true -- успешная авторизация; false -- неуспешная
     */
    @Override
    public boolean auth(UserEntity userEntity) {
        return false;
    }

    /**
     * Пытается зарегистрировать.
     *
     * @param userEntity
     * @return true -- успешная регистрация; false -- неуспешная
     */
    @Override
    public boolean register(UserEntity userEntity) {
        return false;
    }

    @Override
    public boolean logout(UserEntity userEntity) {
        return false;
    }

    @Override
    public UserEntity getUser(long userId) {
        return null;
    }
}
