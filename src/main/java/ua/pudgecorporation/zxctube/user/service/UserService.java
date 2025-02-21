package ua.pudgecorporation.zxctube.user.service;

import ua.pudgecorporation.zxctube.core.service.CommonCrudService;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;

import java.util.Optional;

public interface UserService extends CommonCrudService<UserDTO> {
    Optional<UserDTO> findByEmail(String email);
    Optional<UserDTO> findByKeycloakUuid(String keycloakUuid);
}
