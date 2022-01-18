package ru.kastricyn.web4.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import ru.kastricyn.web4.entity.Point;

@EnableJpaRepositories
public interface PointRepository extends CrudRepository<Point, Long> {
}
