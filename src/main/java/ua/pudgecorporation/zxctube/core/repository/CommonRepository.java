package ua.pudgecorporation.zxctube.core.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<ENTITY> extends JpaRepositoryImplementation<ENTITY, Long> {
}
