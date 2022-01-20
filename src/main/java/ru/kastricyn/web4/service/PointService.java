package ru.kastricyn.web4.service;

import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.entity.UserEntity;

import java.util.List;

public interface PointService {
    boolean checkPointInArea(PointEntity pointEntity);
    void addPoint(PointEntity pointEntity);
    List<PointEntity> getAllPoint();
    List<PointEntity> getAllPointByUser(UserEntity userEntity);

}
