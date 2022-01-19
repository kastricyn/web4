package ru.kastricyn.web4.service;

import org.jetbrains.annotations.Nullable;
import ru.kastricyn.web4.entity.User;

public interface UserService {

    /**
     * Пытается авторизовать.
     *
     * @param user
     * @return true -- успешная авторизация; false -- неуспешная
     */
    boolean auth(User user);

    /**
     * Пытается зарегистрировать.
     *
     * @param user
     * @return true -- успешная регистрация; false -- неуспешная
     */
    boolean register(User user);

    boolean logout(User user);

    @Nullable
    User getUser(long userId);
}
