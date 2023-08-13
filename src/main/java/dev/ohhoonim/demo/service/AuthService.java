package dev.ohhoonim.demo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import dev.ohhoonim.demo.config.service.JwtService;
import dev.ohhoonim.demo.controller.dto.AuthResponse;
import dev.ohhoonim.demo.model.secondary.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    
    // public User authenticate(User user) {
    public AuthResponse authenticate(User user) {
       authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
       ) ;
       return new AuthResponse(jwtService.generateToken(user));
    }
    
}
