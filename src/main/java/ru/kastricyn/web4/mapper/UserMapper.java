package ru.kastricyn.web4.mapper;

import org.springframework.stereotype.Service;
import ru.kastricyn.web4.dto.UserDto;
import ru.kastricyn.web4.entity.UserEntity;
import ru.kastricyn.web4.security.CustomUserDetails;

@Service
public class UserMapper {
    public UserEntity getUserEntityFromUserDto(UserDto.In user){
        UserEntity target = new UserEntity();
        target.setLogin(user.getLogin());
        target.setPassword(user.getPassword());
        return target;
    }

    public UserDto.Out getUserDtoFromUserEntity(UserEntity user) {
        UserDto.Out target = new UserDto.Out();
        target.setLogin(user.getLogin());
        target.setId(user.getId());
        return target;
    }

    public CustomUserDetails getCustomUserDetailsFromUserEntity(UserEntity userEntity) {
        CustomUserDetails target = new CustomUserDetails();
        target.setId(userEntity.getId());
        target.setUsername(userEntity.getLogin());
        target.setPassword(userEntity.getPassword());
        return target;
    }
}
