package ua.pudgecorporation.zxctube.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pudgecorporation.zxctube.auth.dto.AuthResponse;
import ua.pudgecorporation.zxctube.auth.dto.LoginRequest;
import ua.pudgecorporation.zxctube.auth.dto.RegistrationRequest;
import ua.pudgecorporation.zxctube.auth.service.AuthService;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService service;

    @PostMapping("login")
    public ResponseEntity<AuthResponse<UserDTO>> login(@RequestBody LoginRequest request) {
        return handleResponseStatus(service.login(request));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse<UserDTO>> register(@RequestBody RegistrationRequest request) {
        return handleResponseStatus(service.register(request));
    }

    private <T> ResponseEntity<AuthResponse<T>> handleResponseStatus(AuthResponse<T> response) {
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
