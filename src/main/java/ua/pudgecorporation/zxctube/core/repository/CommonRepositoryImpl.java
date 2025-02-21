package ua.pudgecorporation.zxctube.core.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class CommonRepositoryImpl<ENTITY> extends SimpleJpaRepository<ENTITY, Long> implements CommonRepository<ENTITY> {
    protected final EntityManager em;

    public CommonRepositoryImpl(Class<ENTITY> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        em = entityManager;
    }
}
