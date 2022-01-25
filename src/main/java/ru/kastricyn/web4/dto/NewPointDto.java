package ru.kastricyn.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPointDto implements Serializable {
    @Min(-5)
    @Max(5)
    @NotNull(message = "не должно быть пустым")
    private Double x;
    @Min(-3)
    @Max(5)
    @NotNull(message = "не должно быть пустым")
    private Double y;
    @Min(-5)
    @Max(5)
    @NotNull(message = "не должно быть пустым")
    private Double r;
}
