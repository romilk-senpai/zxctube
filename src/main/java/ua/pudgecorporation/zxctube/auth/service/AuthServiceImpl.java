package ua.pudgecorporation.zxctube.auth.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.pudgecorporation.zxctube.auth.dto.AuthResponse;
import ua.pudgecorporation.zxctube.auth.dto.CredentialsDTO;
import ua.pudgecorporation.zxctube.auth.dto.LoginRequest;
import ua.pudgecorporation.zxctube.auth.dto.RegistrationRequest;
import ua.pudgecorporation.zxctube.auth.entity.CredentialsEntity;
import ua.pudgecorporation.zxctube.auth.mapper.CredentialsMapper;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;
import ua.pudgecorporation.zxctube.user.service.UserService;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final CredentialsService credentialsService;
    private final CredentialsMapper credentialsMapper;

    @Override
    public AuthResponse<UserDTO> register(RegistrationRequest request) {
        Optional<CredentialsDTO> credentialsOpt = credentialsService.findByEmail(request.getEmail());

        if (credentialsOpt.isPresent()) {
            return AuthResponse.ofFail();
        }

        UserDTO userDTO = userService.create(UserDTO.builder().email(request.getEmail()).build());
        CredentialsDTO credentialsDTO = credentialsService.create(
                CredentialsDTO.builder()
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .userUuid(userDTO.getUuid())
                        .build()
        );

        return new AuthResponse<UserDTO>(true, credentialsDTO.getToken(), userDTO);
    }

    @Override
    public AuthResponse<UserDTO> login(LoginRequest request) {
        Optional<CredentialsDTO> credentialsOpt = credentialsService.findByEmail(request.getEmail());

        if (credentialsOpt.isEmpty()) {
            return AuthResponse.ofFail();
        }

        CredentialsDTO credentialsDTO = credentialsOpt.get();

        if (!credentialsDTO.getPassword().equals(request.getPassword())) {
            return AuthResponse.ofFail();
        }

        if (Instant.now().isAfter(credentialsDTO.getTokenExpireTime())) {
            CredentialsEntity credentials = credentialsMapper.mapToEntity(credentialsDTO);

            credentials.generateNewToken();

            credentialsDTO = credentialsMapper.mapToDTO(credentials);

            credentialsService.update(credentialsDTO.getUuid(), credentialsDTO);
        }

        UserDTO userDTO = userService.findByUuid(credentialsDTO.getUserUuid());

        return new AuthResponse<UserDTO>(true, credentialsDTO.getToken(), userDTO);
    }
}
