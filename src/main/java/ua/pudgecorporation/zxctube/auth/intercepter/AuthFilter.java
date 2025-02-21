package ua.pudgecorporation.zxctube.auth.intercepter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.pudgecorporation.zxctube.auth.dto.CredentialsDTO;
import ua.pudgecorporation.zxctube.auth.service.CredentialsService;
import ua.pudgecorporation.zxctube.core.exception.UnauthorizedException;

import java.io.IOException;
import java.time.Instant;
import java.util.Optional;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final CredentialsService credentialsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        String token = request.getHeader("token");

        System.out.println(token);

        if (NotRequiredAuthenticationURL.LOGIN.getURL().equals(requestURI) || NotRequiredAuthenticationURL.REGISTER.getURL().equals(requestURI)) {
            filterChain.doFilter(request, response);
        } else {
            if (isNull(token)) {
                throw new UnauthorizedException();
            }

            Optional<CredentialsDTO> tokenOpt = credentialsService.findByToken(token);

            if (tokenOpt.isEmpty()) {
                throw new UnauthorizedException();
            }

            if (Instant.now().isAfter(tokenOpt.get().getTokenExpireTime())) {
                throw new UnauthorizedException();
            }

            filterChain.doFilter(request, response);
        }
    }
}