package com.beneficio.beneficio.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    long id;
    String username;
    String password;
    String firstname;
    String lastname;
    String country;
    Long role; // Campo para el rol
}
