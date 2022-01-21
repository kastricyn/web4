package ru.kastricyn.web4.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.web4.dto.UserDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    @GetMapping("/echo")
    @ResponseBody
    public String echo(@RequestParam(name = "s") String s) {
        return s;
    }

    @PostMapping("/echo")
    @ResponseBody
    public UserDto.In echo(@RequestBody UserDto.In s) {
        return s;
    }
}
