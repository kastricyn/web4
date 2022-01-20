package ru.kastricyn.web4.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import ru.kastricyn.web4.entity.PointEntity;
import ru.kastricyn.web4.entity.UserEntity;

import java.util.List;

@EnableJpaRepositories
public interface PointRepository extends CrudRepository<PointEntity, Long> {
    List<PointEntity> getAllByUserEntity(UserEntity userEntity);
}
