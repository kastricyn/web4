package ru.kastricyn.web4.service;

import lombok.NonNull;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.dto.PointDto;
import ru.kastricyn.web4.entity.PointEntity;

import java.util.List;

import static java.lang.Math.abs;

public interface PointService {
    static boolean checkPointInArea(PointEntity pointEntity) {
        final double x = pointEntity.getX();
        final double y = pointEntity.getY();
        final double r = pointEntity.getR();
        return x * r <= 0 && y * r >= 0 && y / r - 0.5 * x / r <= 1 || //треугольник r>=0 и r<0
                x * r >= 0 && y * r >= 0 && Math.hypot(x, y) <= abs(r) || //окружность r>=0 и r<0
                x * r >= 0 && y * r <= 0 && abs(x) <= abs(r) && 2 * abs(y) <= abs(r); // прямоугольник для r>=0 b r<0
    }

    @NonNull
    PointDto addPoint(NewPointDto point);

    List<PointDto> getAllByCurrentUser();
}
