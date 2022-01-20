package ru.kastricyn.web4.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.dto.NewPointDto;
import ru.kastricyn.web4.dto.PointDto;
import ru.kastricyn.web4.service.PointService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shots")
public class PointController {
    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PointDto> getAllShots() {
        return pointService.getAllByCurrentUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PointDto createShot(@RequestBody @Valid NewPointDto point) {
        return pointService.addPoint(point);
    }
}