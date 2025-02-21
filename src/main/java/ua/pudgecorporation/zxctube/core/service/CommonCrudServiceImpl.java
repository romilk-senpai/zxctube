package ua.pudgecorporation.zxctube.core.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ua.pudgecorporation.zxctube.core.Identifiable;
import ua.pudgecorporation.zxctube.core.exception.NotFoundException;
import ua.pudgecorporation.zxctube.core.mapper.EntityMapper;
import ua.pudgecorporation.zxctube.core.repository.CommonRepository;
import ua.pudgecorporation.zxctube.core.repository.specification.UuidSpecification;

@Transactional
@RequiredArgsConstructor
public abstract class CommonCrudServiceImpl<ENTITY, DTO extends Identifiable> implements CommonCrudService<DTO> {
    private final CommonRepository<ENTITY> repository;
    private final EntityMapper<ENTITY, DTO> mapper;

    public DTO create(DTO dto) {
        ENTITY dbEntity = repository.save(mapper.mapToEntity(dto));
        return mapper.mapToDTO(dbEntity);
    }

    public void delete(String uuid) {
        ENTITY entity = repository.findOne(new UuidSpecification<>(uuid)).orElseThrow(NotFoundException::new);

        if (entity == null) {
            throw new NotFoundException();
        }

        repository.delete(entity);
    }

    public DTO findByUuid(String uuid) {
        ENTITY entity = repository.findOne(new UuidSpecification<>(uuid)).orElseThrow(NotFoundException::new);

        return mapper.mapToDTO(entity);
    }

    public DTO update(String uuid, DTO dto) {
        ENTITY entity = repository.findOne(new UuidSpecification<>(uuid)).orElseThrow(NotFoundException::new);

        ENTITY externalEntity = mapper.mapToEntity(dto);

        updateEntity(entity, externalEntity);

        ENTITY savedEntity = repository.save(entity);

        return mapper.mapToDTO(savedEntity);
    }

    protected abstract void updateEntity(ENTITY entity, ENTITY externalEntity);
}
