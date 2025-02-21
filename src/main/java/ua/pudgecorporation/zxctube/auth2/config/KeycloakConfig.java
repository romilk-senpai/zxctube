package ua.pudgecorporation.zxctube.auth2.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.ClientBuilderWrapper;
import org.keycloak.admin.client.JacksonProvider;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.BasicAuthFilter;
import org.keycloak.admin.client.token.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

@Import(WebSecurityConfig.class)
@AutoConfiguration
@PropertySource("classpath:application.yml")
public class KeycloakConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String serverUri;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Value("${keycloak.resource}")
    private String resource;

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUri)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }

    @Bean
    public TokenService tokenService(Client client) {
        WebTarget target = client.target(serverUri);

        target.register(new BasicAuthFilter(resource, clientSecret));

        return Keycloak.getClientProvider().targetProxy(target, TokenService.class);
    }

    @Bean
    public Client client() {
        return ClientBuilderWrapper.create(null, false)
                .register(JacksonProvider.class, 100)
                .build();
    }
}
