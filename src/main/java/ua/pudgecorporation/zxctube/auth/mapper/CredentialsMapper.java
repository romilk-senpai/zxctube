package ua.pudgecorporation.zxctube.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ua.pudgecorporation.zxctube.auth.dto.CredentialsDTO;
import ua.pudgecorporation.zxctube.auth.entity.CredentialsEntity;
import ua.pudgecorporation.zxctube.core.mapper.EntityMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CredentialsMapper extends EntityMapper<CredentialsEntity, CredentialsDTO> {
}
