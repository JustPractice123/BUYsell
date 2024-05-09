package com.example.BUYsell.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Table(name = "roles")
@Entity
@RequiredArgsConstructor
@Data
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role")
    private String role;
    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return role;
    }
}
