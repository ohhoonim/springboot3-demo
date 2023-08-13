package dev.ohhoonim.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ohhoonim.demo.controller.dto.AuthRequest;
import dev.ohhoonim.demo.controller.dto.AuthResponse;
import dev.ohhoonim.demo.model.secondary.User;
import dev.ohhoonim.demo.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    // public ResponseEntity<User> authenticate(@RequestBody User user) {
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest login) {
        User user = User.builder()
            .email(login.email()) 
            .password(login.password())
            .build(); 
        
        return ResponseEntity.ok(authService.authenticate(user));

        // authority : 회원가입 , 인가 
        // authentication : 로그인 , 인증 
        // auth 

    }
}
