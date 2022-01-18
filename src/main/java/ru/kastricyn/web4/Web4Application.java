package ru.kastricyn.web4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@SpringBootApplication
@EntityScan(basePackages = {"ru.kastricyn.web4.entity"})
public class Web4Application {

    public static void main(String[] args) {
        SpringApplication.run(Web4Application.class, args);
    }


}
