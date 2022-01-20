package ru.kastricyn.web4.service;

import lombok.NonNull;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.dto.PointDto;
import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.entity.UserEntity;

import java.util.List;

public interface PointService {
    boolean checkPointInArea(PointEntity pointEntity);
    @NonNull
    PointDto addPoint(NewPointDto point);

    List<PointDto> getAllByCurrentUser();
}
