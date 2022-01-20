package ru.kastricyn.web4.mapper;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.dto.PointDto;
import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.service.PointService;
import ru.kastricyn.web4.service.UserService;

@Service
public class PointMapper {
    private final UserService userService;

    public PointMapper(UserService userService) {
        this.userService = userService;
    }

    public PointEntity getPointEntityFromPointDto(NewPointDto point, long userId) {
        PointEntity target = new PointEntity();
        target.setX(point.getX());
        target.setY(point.getY());
        target.setR(point.getR());
        target.setResult(PointService.checkPointInArea(target));
        target.setUserEntity(userService.getUserEntity(userId));
        return target;
    }

    public PointDto getPointDtoFromPointEntity(PointEntity point) {
        PointDto target = new PointDto();
        target.setX(point.getX());
        target.setY(point.getY());
        target.setR(point.getR());
        target.setResult(point.isResult());
        return target;
    }
}
