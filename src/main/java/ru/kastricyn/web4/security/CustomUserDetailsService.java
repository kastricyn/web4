package ru.kastricyn.web4.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kastricyn.web4.entity.UserEntity;
import ru.kastricyn.web4.mapper.UserMapper;
import ru.kastricyn.web4.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    private final UserMapper userMapper;

    public CustomUserDetailsService(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.getUserEntity(username);
        return userMapper.getCustomUserDetailsFromUserEntity(user);
    }
}
