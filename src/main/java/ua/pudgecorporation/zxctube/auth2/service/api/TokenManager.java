package ua.pudgecorporation.zxctube.auth2.service.api;

import org.keycloak.representations.AccessTokenResponse;
import ua.pudgecorporation.zxctube.auth.dto.LoginRequest;
import ua.pudgecorporation.zxctube.auth.dto.RegistrationRequest;

import javax.ws.rs.core.Response;

public interface TokenManager {
    AccessTokenResponse grantTokenLogin(LoginRequest loginRequest);

    String extractSubjectFromToken(String token);

    Response createUser(RegistrationRequest request);
}
