package ru.kastricyn.web4.service;

import ru.kastricyn.web4.entity.Point;
import ru.kastricyn.web4.entity.User;

import java.util.List;

public interface PointService {
    boolean checkPointInArea(Point point);
    void addPoint(Point point);
    List<Point> getAllPoint();
    List<Point> getAllPointByUser(User user);

}
