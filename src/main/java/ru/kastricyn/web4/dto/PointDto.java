package ru.kastricyn.web4.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PointDto implements Serializable {
    private final long id;
    private final double x;
    private final double y;
    private final double r;
    private final boolean result;
}
