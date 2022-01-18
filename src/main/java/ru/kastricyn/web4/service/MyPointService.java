package ru.kastricyn.web4.service;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.entity.Point;

import java.util.Random;

@Service
public class MyPointService implements PointService {
    @Override
    public boolean checkPointInArea(Point point) {
        return new Random().nextBoolean();
    }
}
