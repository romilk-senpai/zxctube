package ua.pudgecorporation.zxctube.auth.service;

import ua.pudgecorporation.zxctube.auth.dto.CredentialsDTO;
import ua.pudgecorporation.zxctube.core.service.CommonCrudService;

import java.util.Optional;

public interface CredentialsService extends CommonCrudService<CredentialsDTO> {
    Optional<CredentialsDTO> findByEmail(String email);
    Optional<CredentialsDTO> findByToken(String token);
}
