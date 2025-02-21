package ua.pudgecorporation.zxctube.video.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ua.pudgecorporation.zxctube.core.mapper.EntityMapper;
import ua.pudgecorporation.zxctube.video.dto.VideoDTO;
import ua.pudgecorporation.zxctube.video.entity.Video;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoMapper extends EntityMapper<Video, VideoDTO> {

}