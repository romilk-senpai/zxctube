package ua.pudgecorporation.zxctube.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "user_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String displayName;
    private String email;
    private String avatarUuid;
    private String keycloakUuid;
    @CreatedDate
    private Instant createDate;
    @LastModifiedDate
    private Instant updateDate;

    @PrePersist
    public void generateUuid() {
        if (!StringUtils.hasLength(uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }
    }
}
