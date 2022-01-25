package ru.kastricyn.web4.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.dto.PointDto;
import ru.kastricyn.web4.mapper.PointMapper;
import ru.kastricyn.web4.repository.PointRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    public @NonNull PointDto addPoint(NewPointDto point) {
        return mapper.getPointDtoFromPointEntity(pointRepository.save(mapper.getPointEntityFromPointDto(point,
                userService.getCurrentUserId())));
    }

    @Override
    public List<PointDto> getAllByCurrentUser() {
        return pointRepository.getAllByUserEntity(userService.getCurrentUserEntity())
                .stream()
                .map(mapper::getPointDtoFromPointEntity)
                .collect(Collectors.toList());
    }
}
