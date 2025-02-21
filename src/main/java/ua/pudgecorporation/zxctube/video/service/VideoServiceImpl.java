package ua.pudgecorporation.zxctube.video.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.pudgecorporation.zxctube.core.service.CommonCrudServiceImpl;
import ua.pudgecorporation.zxctube.video.dto.VideoDTO;
import ua.pudgecorporation.zxctube.video.entity.Video;
import ua.pudgecorporation.zxctube.video.mapper.VideoMapper;
import ua.pudgecorporation.zxctube.video.repostiory.VideoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl extends CommonCrudServiceImpl<Video, VideoDTO> implements VideoService {
    private final VideoRepository repository;
    private final VideoMapper mapper;

    public VideoServiceImpl(VideoRepository repository, VideoMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void updateEntity(Video video, Video externalEntity) {
        video.setVideoDescription(externalEntity.getVideoDescription());
        video.setVideoTitle(externalEntity.getVideoTitle());
        video.setVideoPreviewUuid(externalEntity.getVideoPreviewUuid());
    }

    @Override
    public Page<VideoDTO> getPage(Pageable pageable) {
        Page<Video> page = repository.findAll(pageable);
        List<Video> content = page.getContent();
        List<VideoDTO> list = new ArrayList<VideoDTO>();
        for (Video video : content) {
            list.add(mapper.mapToDTO(video));
        }
        return new PageImpl<VideoDTO>(list, pageable, page.getTotalElements());
    }
}
