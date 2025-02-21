package ua.pudgecorporation.zxctube.video.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.pudgecorporation.zxctube.core.service.CommonCrudService;
import ua.pudgecorporation.zxctube.video.dto.VideoDTO;

public interface VideoService extends CommonCrudService<VideoDTO> {
    public Page<VideoDTO> getPage(Pageable page);
}
