package ru.kastricyn.web4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public abstract class UserDto implements Serializable {
    @Getter
    @Setter
    public static class In {
        @NotBlank
        private String login;
        @NotBlank
        private String password;
    }

    @Getter
    @Setter
    public static class Out {
        private long id;
        private String login;
    }
}
