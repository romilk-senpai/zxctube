package ua.pudgecorporation.zxctube.auth.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ua.pudgecorporation.zxctube.auth.entity.CredentialsEntity;
import ua.pudgecorporation.zxctube.core.repository.CommonRepositoryImpl;

@Repository
public class CredentialsRepositoryImpl extends CommonRepositoryImpl<CredentialsEntity> implements CredentialsRepository {
    public CredentialsRepositoryImpl(EntityManager entityManager) {
        super(CredentialsEntity.class, entityManager);
    }
}
