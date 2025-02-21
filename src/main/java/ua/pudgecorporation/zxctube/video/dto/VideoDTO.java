package ua.pudgecorporation.zxctube.video.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.pudgecorporation.zxctube.core.Identifiable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO implements Identifiable {
    private String uuid;
    private String videoFileUuid;
    private String videoPreviewUuid;
    private String authorUuid;
    private String videoTitle;
    private String videoDescription;
}
