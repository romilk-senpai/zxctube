package ua.pudgecorporation.zxctube.core.repository.specification;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class UuidSpecification<ENTITY> implements Specification<ENTITY> {
    private final String uuid;

    @Override
    public Predicate toPredicate(Root<ENTITY> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<String> uuidPath = root.get("uuid");
        return criteriaBuilder.equal(uuidPath, uuid);
    }
}
