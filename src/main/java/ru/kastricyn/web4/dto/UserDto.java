package ru.kastricyn.web4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public abstract class UserDto implements Serializable {
    @Getter
    @Setter
    public static class In implements Cloneable{
        @NotBlank
        private String login;
        @NotBlank
        private String password;

        @Override
        public In clone() {
            try {
                In clone = (In) super.clone();
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    @Getter
    @Setter
    public static class Out {
        private long id;
        private String login;
    }
}
