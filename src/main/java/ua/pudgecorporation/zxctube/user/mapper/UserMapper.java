package ua.pudgecorporation.zxctube.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ua.pudgecorporation.zxctube.core.mapper.EntityMapper;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;
import ua.pudgecorporation.zxctube.user.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends EntityMapper<User, UserDTO> {
}
