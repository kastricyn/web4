package ru.kastricyn.web4.service;

import lombok.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kastricyn.web4.dto.TokenDto;
import ru.kastricyn.web4.dto.UserDto;
import ru.kastricyn.web4.entity.UserEntity;
import ru.kastricyn.web4.exception.NotFoundDataException;
import ru.kastricyn.web4.exception.UserAlreadyExistException;
import ru.kastricyn.web4.exception.WrongPasswordException;
import ru.kastricyn.web4.mapper.UserMapper;
import ru.kastricyn.web4.repository.UserRepository;
import ru.kastricyn.web4.security.CustomUserDetails;
import ru.kastricyn.web4.security.JwtTokenProvider;

import javax.naming.NameNotFoundException;
import javax.validation.ConstraintViolationException;

@Service
public class MyUserService implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public MyUserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public @NonNull UserEntity getUserEntity(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundDataException("Не найден пользователь с " +
                "id " + userId));
    }

    @Override
    public @NonNull UserEntity getUserEntity(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new NotFoundDataException("Не найден пользователь с логином " + login));
    }

    public long getCurrentUserId() {
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    @Override
    public @NonNull UserEntity getCurrentUserEntity() {
        return getUserEntity(getCurrentUserId());
    }

    @Override
    public @NonNull UserDto.Out getCurrentUserDto() {
        return mapper.getUserDtoFromUserEntity(getCurrentUserEntity());
    }

    @Override
    public @NonNull UserDto.Out getUserDto(long userId) {
        return mapper.getUserDtoFromUserEntity(getUserEntity(userId));
    }

    @Override
    public @NonNull UserDto.Out getUserDto(String login) {
        return mapper.getUserDtoFromUserEntity(getUserEntity(login));
    }

    @Override
    public @NonNull UserDto.Out create(UserDto.In user) {
        return mapper.getUserDtoFromUserEntity(mapper.getUserEntityFromUserDto(user));
    }

    @Override
    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }
}
