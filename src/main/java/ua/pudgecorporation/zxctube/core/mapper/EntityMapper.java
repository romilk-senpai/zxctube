package ua.pudgecorporation.zxctube.core.mapper;

import ua.pudgecorporation.zxctube.core.Identifiable;

public interface EntityMapper<ENTITY, DTO extends Identifiable> {
    ENTITY mapToEntity(DTO dto);

    DTO mapToDTO(ENTITY entity);
}
