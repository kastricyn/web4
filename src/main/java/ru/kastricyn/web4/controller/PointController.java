package ru.kastricyn.web4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.entity.UserEntity;
import ru.kastricyn.web4.service.PointService;
import ru.kastricyn.web4.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/point")
public class PointController {
    private final UserService userService;
    private final PointService pointService;

    public PointController(UserService userService, PointService pointService) {
        this.userService = userService;
        this.pointService = pointService;
    }

    /**
     * @return список всех точек пользователя, если пользователя нет
     */
    @GetMapping("/{userId}")
    public List<PointEntity> getPointByUser(@PathVariable long userId) {
        return null;
    }

    /**
     * @return true -- точка добавлена, false -- что-то пошло не так
     */
    @PostMapping
    public boolean addPoint(@RequestBody @Valid NewPointDto pointDto) {
        return false; //todo
    }
}
