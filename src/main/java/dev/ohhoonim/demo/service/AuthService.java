package dev.ohhoonim.demo.service;

import java.io.IOException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import dev.ohhoonim.demo.config.service.JwtService;
import dev.ohhoonim.demo.controller.dto.AuthRequest;
import dev.ohhoonim.demo.controller.dto.AuthResponse;
import dev.ohhoonim.demo.model.secondary.User;
import dev.ohhoonim.demo.repository.secondary.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    // public User authenticate(User user) {
    public AuthResponse authenticate(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return new AuthResponse(jwtService.generateToken(user),
                jwtService.generateRefreshToken(user));
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail; // username
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            User user= this.userRepository.findByEmail(userEmail).get();
            if (jwtService.isTokenValid(refreshToken, user)) {
               String accessToken = jwtService.generateToken(user);
               AuthResponse authResponse = new AuthResponse(accessToken, refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

}
