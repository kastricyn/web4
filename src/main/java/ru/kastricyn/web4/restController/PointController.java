package ru.kastricyn.web4.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.dto.RestResponseDto;
import ru.kastricyn.web4.entity.Point;
import ru.kastricyn.web4.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/point")
public class PointController {
    @Autowired
    private UserRepository userRepository;

    /**
     * @return список всех точек пользователя, если пользователя нет
     */
    @GetMapping("/{userId}")
    public RestResponseDto<? extends List<Point>> getPointByUser(@PathVariable long userId) {
        return userRepository.findById(userId).map(user -> new RestResponseDto<>(true,
                new ArrayList<>(user.getPoints()))).orElse(new RestResponseDto<>(false));
    }

    /**
     * @return true -- точка добавлена, false -- что-то пошло не так
     */
    @PutMapping
    public boolean addPoint(@RequestParam() Point point) {
        return false; //todo
    }
}
