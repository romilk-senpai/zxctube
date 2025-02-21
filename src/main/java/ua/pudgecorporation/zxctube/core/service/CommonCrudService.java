package ua.pudgecorporation.zxctube.core.service;

import ua.pudgecorporation.zxctube.core.Identifiable;

public interface CommonCrudService<DTO extends Identifiable> {
    public DTO create(DTO dto);

    public void delete(String uuid);

    public DTO findByUuid(String uuid);

    public DTO update(String uuid, DTO dto);
}
