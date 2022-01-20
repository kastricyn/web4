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
import ru.kastricyn.web4.exception.UserAlreadyExistException;
import ru.kastricyn.web4.exception.WrongPasswordException;
import ru.kastricyn.web4.security.JwtTokenProvider;

import javax.validation.ConstraintViolationException;

@Service
public class MyAuthService implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public MyAuthService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public @NonNull UserDto.Out register(UserDto.In user) throws UserAlreadyExistException {
        try {
            String password = user.getPassword();
            user.setPassword(passwordEncoder.encode(password));
            return userService.create(user);
        } catch (ConstraintViolationException e) {
            throw new UserAlreadyExistException("Уже существует пользователь с логином " + user.getLogin());
        }
    }


    @Override
    public @NonNull TokenDto login(UserDto.In user) throws WrongPasswordException {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.createToken(userService.getUserEntity(user.getLogin()).getId(),
                    user.getLogin());
            return new TokenDto(token);
        } catch (BadCredentialsException ex) {
            throw new WrongPasswordException("Неверный пароль");
        }
    }
}
