package com.example.BUYsell.Services;

import com.example.BUYsell.Models.User;
import com.example.BUYsell.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if (user==null)throw new UsernameNotFoundException("User not found");
        return user;
    }

    private final UserRepository userRepository;

    public boolean createUser(User user){
        if (userRepository.findByEmail(user.getEmail())!=null) return false;
        User newUser=userRepository.save(user);
        log.info("Saving new User with email:{}", user.getEmail());
        return true;
    }
}
