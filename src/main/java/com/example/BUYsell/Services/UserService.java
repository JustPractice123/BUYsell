package com.example.BUYsell.Services;

import com.example.BUYsell.Models.User;
import com.example.BUYsell.Models.enums.Role;
import com.example.BUYsell.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean createUser(User user){
        if (userRepository.findByEmail(user.getEmail())!=null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email:{}", user.getEmail());
        return true;
    }
}
