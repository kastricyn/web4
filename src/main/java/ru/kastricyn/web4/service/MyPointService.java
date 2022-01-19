package ru.kastricyn.web4.service;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.entity.Point;
import ru.kastricyn.web4.entity.User;

import java.util.List;
import java.util.Random;

@Service
public class MyPointService implements PointService {
    @Override
    public boolean checkPointInArea(Point point) {
        return new Random().nextBoolean();
    }

    @Override
    public void addPoint(Point point) {

    }

    @Override
    public List<Point> getAllPoint() {
        return null;
    }

    @Override
    public List<Point> getAllPointByUser(User user) {
        return null;
    }
}
