package com.beneficio.beneficio.Auth;

import com.beneficio.beneficio.Jwt.JwtService;
import com.beneficio.beneficio.User.Role;
import com.beneficio.beneficio.User.RoleRepository;
import com.beneficio.beneficio.User.User;
import com.beneficio.beneficio.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    //servicio par iniciar sesion
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .role(user.getRole().getNombre())
                .id(user.getId())// Incluir el rol en la respuesta
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Role role = roleRepository.findById(request.getRole()).orElseThrow(() -> new RuntimeException("Role not found"));
        User user = User.builder()
                .id(request.getId())  // Asignar el id manualmente
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(role)  // Asignar el rol desde la base de datos
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .role(user.getRole().getNombre())  // Incluir el rol en la respuesta
                .id(user.getId())
                .build();
    }
}
