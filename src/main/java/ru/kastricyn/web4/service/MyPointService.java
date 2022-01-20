package ru.kastricyn.web4.service;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.entity.UserEntity;

import java.util.List;
import java.util.Random;

@Service
public class MyPointService implements PointService {
    @Override
    public boolean checkPointInArea(PointEntity pointEntity) {
        return new Random().nextBoolean();
    }

    @Override
    public void addPoint(PointEntity pointEntity) {

    }

    @Override
    public List<PointEntity> getAllPoint() {
        return null;
    }

    @Override
    public List<PointEntity> getAllPointByUser(UserEntity userEntity) {
        return null;
    }
}
