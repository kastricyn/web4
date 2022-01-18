package ru.kastricyn.web4.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final long id;
    private final String login;
    private final PointDto[] points;
}
