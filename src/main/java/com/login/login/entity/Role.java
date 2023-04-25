package com.login.login.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName name;
    public Role() {
    }
    public Role(RoleName name) {
        this.name = name;
    }
}
