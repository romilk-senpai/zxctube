package ua.pudgecorporation.zxctube.auth2.service;

import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Component;
import ua.pudgecorporation.zxctube.auth.dto.AuthResponse;
import ua.pudgecorporation.zxctube.auth.dto.LoginRequest;
import ua.pudgecorporation.zxctube.auth.dto.RegistrationRequest;
import ua.pudgecorporation.zxctube.auth2.service.api.AuthService;
import ua.pudgecorporation.zxctube.auth2.service.api.TokenManager;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;
import ua.pudgecorporation.zxctube.user.service.UserService;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final TokenManager tokenManager;
    private final UserService userService;

    @Override
    public AuthResponse<UserDTO> register(RegistrationRequest request) {
        String locationHeader;

        try (Response response = tokenManager.createUser(request)) {
            locationHeader = response.getHeaderString(HttpHeaders.LOCATION);
        }

        String keycloakUuid = locationHeader.substring(locationHeader.indexOf("users/") + 6);

        UserDTO userDTO = userService.create(UserDTO.builder()
                .email(request.getEmail())
                .keycloakUuid(keycloakUuid)
                .build());

        AccessTokenResponse accessTokenResponse = tokenManager.grantTokenLogin(new LoginRequest(request.getEmail(), request.getPassword()));

        return new AuthResponse<>(true, accessTokenResponse.getToken(), userDTO);
    }

    @Override
    public AuthResponse<UserDTO> login(LoginRequest request) {
        AccessTokenResponse accessTokenResponse = tokenManager.grantTokenLogin(request);
        String keycloakUuid = tokenManager.extractSubjectFromToken(accessTokenResponse.getToken());

        UserDTO byKeycloakUuid = userService.findByKeycloakUuid(keycloakUuid).orElseThrow();

        return new AuthResponse<UserDTO>(true, accessTokenResponse.getToken(), byKeycloakUuid);
    }
}
