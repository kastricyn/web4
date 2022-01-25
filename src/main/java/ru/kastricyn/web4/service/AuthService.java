package ru.kastricyn.web4.service;

import lombok.NonNull;
import ru.kastricyn.web4.dto.TokenDto;
import ru.kastricyn.web4.dto.UserDto;
import ru.kastricyn.web4.exception.UserAlreadyExistException;
import ru.kastricyn.web4.exception.WrongPasswordException;

public interface AuthService {
    @NonNull UserDto.Out register(UserDto.In user) throws UserAlreadyExistException;

    @NonNull TokenDto login(UserDto.In user) throws WrongPasswordException;
}
