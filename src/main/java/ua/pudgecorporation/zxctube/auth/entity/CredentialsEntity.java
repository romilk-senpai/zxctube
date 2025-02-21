package ua.pudgecorporation.zxctube.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Entity(name = "credentials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String userUuid;
    private String email;
    private String password;
    private String token;
    private Instant tokenExpireTime;

    @PrePersist
    public void prePersistOperation() {
        if (!StringUtils.hasLength(uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }

        if (!StringUtils.hasLength(token)) {
            generateNewToken();
        }
    }

    public void generateNewToken() {
        this.token = UUID.randomUUID().toString();
        this.tokenExpireTime = Instant.now().plus(Duration.ofMinutes(5));
    }
}
