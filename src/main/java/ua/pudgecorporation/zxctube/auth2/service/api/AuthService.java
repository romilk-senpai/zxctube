package ua.pudgecorporation.zxctube.auth2.service.api;

import ua.pudgecorporation.zxctube.auth.dto.AuthResponse;
import ua.pudgecorporation.zxctube.auth.dto.LoginRequest;
import ua.pudgecorporation.zxctube.auth.dto.RegistrationRequest;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;

public interface AuthService {
    AuthResponse<UserDTO> register(RegistrationRequest request);

    AuthResponse<UserDTO> login(LoginRequest request);
}
