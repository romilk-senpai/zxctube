package ua.pudgecorporation.zxctube.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.pudgecorporation.zxctube.core.Identifiable;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialsDTO implements Identifiable {
    private String uuid;
    private String token;
    private String userUuid;
    private String email;
    private String password;
    private Instant tokenExpireTime;
}
