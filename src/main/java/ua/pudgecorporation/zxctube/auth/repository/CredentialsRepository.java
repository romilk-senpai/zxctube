package ua.pudgecorporation.zxctube.auth.repository;

import org.springframework.data.repository.NoRepositoryBean;
import ua.pudgecorporation.zxctube.auth.entity.CredentialsEntity;
import ua.pudgecorporation.zxctube.core.repository.CommonRepository;

@NoRepositoryBean
public interface CredentialsRepository extends CommonRepository<CredentialsEntity> {
}
