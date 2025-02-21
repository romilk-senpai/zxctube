package ua.pudgecorporation.zxctube.auth.service;

import org.springframework.stereotype.Service;
import ua.pudgecorporation.zxctube.auth.dto.CredentialsDTO;
import ua.pudgecorporation.zxctube.auth.entity.CredentialsEntity;
import ua.pudgecorporation.zxctube.auth.mapper.CredentialsMapper;
import ua.pudgecorporation.zxctube.auth.repository.CredentialsRepository;
import ua.pudgecorporation.zxctube.auth.repository.specification.TokenSpecification;
import ua.pudgecorporation.zxctube.core.service.CommonCrudServiceImpl;
import ua.pudgecorporation.zxctube.user.repostiory.specification.EmailSpecification;

import java.util.Optional;

@Service
public class CredentialsServiceImpl extends CommonCrudServiceImpl<CredentialsEntity, CredentialsDTO> implements CredentialsService {
    private final CredentialsRepository repository;
    private final CredentialsMapper mapper;

    public CredentialsServiceImpl(CredentialsRepository repository, CredentialsMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void updateEntity(CredentialsEntity credentialsEntity, CredentialsEntity externalEntity) {
        credentialsEntity.setEmail(externalEntity.getEmail());
        credentialsEntity.setPassword(externalEntity.getPassword());
        credentialsEntity.setToken(externalEntity.getToken());
        credentialsEntity.setTokenExpireTime(externalEntity.getTokenExpireTime());
    }

    @Override
    public Optional<CredentialsDTO> findByEmail(String email) {
        Optional<CredentialsEntity> credentialsOpt = repository.findOne(new EmailSpecification<CredentialsEntity>(email));

        if (credentialsOpt.isPresent()) {
            return Optional.of(mapper.mapToDTO(credentialsOpt.get()));
        }

        return Optional.empty();
    }

    @Override
    public Optional<CredentialsDTO> findByToken(String token) {
        Optional<CredentialsEntity> credentialsOpt = repository.findOne(new TokenSpecification(token));

        if (credentialsOpt.isPresent()) {
            return Optional.of(mapper.mapToDTO(credentialsOpt.get()));
        }

        return Optional.empty();
    }
}
