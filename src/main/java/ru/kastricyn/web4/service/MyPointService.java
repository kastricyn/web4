package ru.kastricyn.web4.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.dto.PointDto;
import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.entity.UserEntity;
import ru.kastricyn.web4.mapper.PointMapper;
import ru.kastricyn.web4.repository.PointRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

@Service
public class MyPointService implements PointService {
    private final PointRepository pointRepository;
    private final UserService userService;
    private final PointMapper mapper;

    public MyPointService(PointRepository pointRepository, UserService userService, PointMapper mapper) {
        this.pointRepository = pointRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public boolean checkPointInArea(PointEntity pointEntity) {
        final double x = pointEntity.getX();
        final double y = pointEntity.getY();
        final double r = pointEntity.getR();
        return x * r <= 0 && y * r >= 0 && y / r - 0.5 * x / r <= 1 || //треугольник r>=0 и r<0
                x * r >= 0 && y * r >= 0 && Math.hypot(x, y) <= abs(r) || //окружность r>=0 и r<0
                x * r >= 0 && y * r <= 0 && abs(x) <= abs(r) && 2 * abs(y) <= abs(r); // прямоугольник для r>=0 b r<0
    }

    @Override
    public @NonNull PointDto addPoint(NewPointDto point) {
        return mapper.getPointDtoFromPointEntity(pointRepository.save(mapper.getPointEntityFromPointDto(point,
                userService.getCurrentUserId())));
    }

    @Override
    public List<PointDto> getAll(UserEntity user) {
        return pointRepository.getAllByUserEntity(userService.getCurrentUserEntity())
                .stream()
                .map(mapper::getPointDtoFromPointEntity)
                .collect(Collectors.toList());
    }
}
