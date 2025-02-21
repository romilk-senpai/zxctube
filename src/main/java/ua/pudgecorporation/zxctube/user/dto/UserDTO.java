package ua.pudgecorporation.zxctube.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.pudgecorporation.zxctube.core.Identifiable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Identifiable {
    private String uuid;
    private String displayName;
    private String email;
    private String avatarUuid;
    private String keycloakUuid;
}
