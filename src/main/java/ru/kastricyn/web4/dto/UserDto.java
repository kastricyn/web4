package ru.kastricyn.web4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
