package ru.kastricyn.web4.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import ru.kastricyn.web4.entity.UserEntity;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);
}
