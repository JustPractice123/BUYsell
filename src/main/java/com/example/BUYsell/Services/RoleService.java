package com.example.BUYsell.Services;

import com.example.BUYsell.Models.Role;
import com.example.BUYsell.Repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;
    public List<Role> setDefaultRole(){
        List<Role> roles=new ArrayList<>();
        Role role=roleRepository.findByRole("user_role");
        roles.add(role);
        return roles;
    }
}
