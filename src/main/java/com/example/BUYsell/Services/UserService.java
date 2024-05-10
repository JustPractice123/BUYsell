package com.example.BUYsell.Services;

import com.example.BUYsell.Models.Role;
import com.example.BUYsell.Models.User;
import com.example.BUYsell.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserService implements UserDetailsService {
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if (user==null)throw new UsernameNotFoundException("User not found");
        return user;
    }

    private final UserRepository userRepository;

    public boolean createUser(String email, String password, String name, String phoneNumber){
        if (userRepository.findByEmail(email)!=null) return false;
        User newUser=new User();
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setName(name);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setRoles(roleService.setDefaultRole());
        userRepository.save(newUser);
        log.info("Saving new User with email:{}", newUser.getEmail());
        return true;
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
