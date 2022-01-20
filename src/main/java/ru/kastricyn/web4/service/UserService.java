package ru.kastricyn.web4.service;

import org.jetbrains.annotations.Nullable;
import ru.kastricyn.web4.entity.UserEntity;

public interface UserService {

    /**
     * Пытается авторизовать.
     *
     * @param userEntity
     * @return true -- успешная авторизация; false -- неуспешная
     */
    boolean auth(UserEntity userEntity);

    /**
     * Пытается зарегистрировать.
     *
     * @param userEntity
     * @return true -- успешная регистрация; false -- неуспешная
     */
    boolean register(UserEntity userEntity);

    boolean logout(UserEntity userEntity);

    @Nullable
    UserEntity getUser(long userId);
}
