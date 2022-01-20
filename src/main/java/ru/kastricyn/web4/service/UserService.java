package ru.kastricyn.web4.service;

import lombok.NonNull;
import ru.kastricyn.web4.dto.TokenDto;
import ru.kastricyn.web4.dto.UserDto;
import ru.kastricyn.web4.entity.UserEntity;
import ru.kastricyn.web4.exception.UserAlreadyExistException;
import ru.kastricyn.web4.exception.WrongPasswordException;

import javax.naming.NameNotFoundException;

public interface UserService {

    @NonNull
    UserEntity getUserEntity(long userId);

    @NonNull
    UserEntity getUserEntity(String login);

    long getCurrentUserId();

    @NonNull
    UserEntity getCurrentUserEntity();

    @NonNull
    UserDto.Out getCurrentUserDto();

    @NonNull
    UserDto.Out getUserDto(long userId);

    @NonNull
    UserDto.Out getUserDto(String login);

    @NonNull
    TokenDto login(UserDto.In user) throws WrongPasswordException;

    @NonNull
    UserDto.Out register(UserDto.In user) throws UserAlreadyExistException;

    @NonNull
    UserDto.Out create(UserDto.In user);

    UserEntity create(UserEntity user);


}
