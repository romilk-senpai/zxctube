package ua.pudgecorporation.zxctube.video.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String videoFileUuid;
    private String videoPreviewUuid;
    private String authorUuid;
    private String videoTitle;
    private String videoDescription;
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
