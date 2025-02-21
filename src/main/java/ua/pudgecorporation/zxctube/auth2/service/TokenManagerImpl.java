package ua.pudgecorporation.zxctube.auth2.service;

import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.token.TokenService;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;
import ua.pudgecorporation.zxctube.auth.dto.LoginRequest;
import ua.pudgecorporation.zxctube.auth.dto.RegistrationRequest;
import ua.pudgecorporation.zxctube.auth2.service.api.TokenManager;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenManagerImpl implements TokenManager {
    @Value("${keycloak.realm}")
    private String realm;

    private final Keycloak keycloak;
    private final TokenService tokenService;
    private final JwtDecoder jwtDecoder;

    @Override
    public AccessTokenResponse grantTokenLogin(LoginRequest loginRequest) {
        Form loginForm = new Form()
                .param(OAuth2Constants.GRANT_TYPE, OAuth2Constants.PASSWORD)
                .param(OAuth2Constants.USERNAME, loginRequest.getEmail())
                .param(OAuth2Constants.PASSWORD, loginRequest.getPassword());

        return tokenService.grantToken(realm, loginForm.asMap());
    }

    @Override
    public String extractSubjectFromToken(String token) {
        return jwtDecoder.decode(token).getSubject();
    }

    @Override
    public Response createUser(RegistrationRequest request) {
        return keycloak.realm(realm).users().create(prepareUserRepresentation(request));
    }

    private UserRepresentation prepareUserRepresentation(RegistrationRequest request) {
        UserRepresentation newUser = new UserRepresentation();
        newUser.setUsername(request.getEmail());
        newUser.setCredentials(List.of(preparePasswordRepresentation(request.getPassword())));
        newUser.setEnabled(true);
        newUser.setEmailVerified(true);
        return newUser;
    }

    private CredentialRepresentation preparePasswordRepresentation(String password) {
        CredentialRepresentation cR = new CredentialRepresentation();
        cR.setTemporary(false);
        cR.setType(CredentialRepresentation.PASSWORD);
        cR.setValue(password);
        return cR;
    }
}
