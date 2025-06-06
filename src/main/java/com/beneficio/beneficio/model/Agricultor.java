package com.beneficio.beneficio.model;

import com.beneficio.beneficio.User.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agricultor", schema = "agricultor")

public class Agricultor {
    @Id
    private Long id;
    @Basic
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String lastname;
    private String firstname;
    private String country;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}
