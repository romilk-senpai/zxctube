package ua.pudgecorporation.zxctube.auth.repository.specification;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ua.pudgecorporation.zxctube.auth.entity.CredentialsEntity;

@RequiredArgsConstructor
public class TokenSpecification implements Specification<CredentialsEntity> {
    private final String token;

    @Override
    public Predicate toPredicate(Root<CredentialsEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<String> tokenPath = root.get("token");
        return criteriaBuilder.equal(tokenPath, token);
    }
}
