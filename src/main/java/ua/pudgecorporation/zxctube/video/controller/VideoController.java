package ua.pudgecorporation.zxctube.video.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pudgecorporation.zxctube.core.controller.CommonController;
import ua.pudgecorporation.zxctube.video.dto.VideoDTO;
import ua.pudgecorporation.zxctube.video.service.VideoService;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController extends CommonController<VideoDTO> {
    private final VideoService service;

    public VideoController(VideoService service) {
        super(service);
        this.service = service;
    }

    @PostMapping("/page")
    public ResponseEntity<Page<VideoDTO>> getPage(@ParameterObject Pageable page) {
        return ResponseEntity.ok(this.service.getPage(page));
    }
}
