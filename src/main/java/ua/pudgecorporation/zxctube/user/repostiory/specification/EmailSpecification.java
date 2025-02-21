package ua.pudgecorporation.zxctube.user.repostiory.specification;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class EmailSpecification<ENTITY> implements Specification<ENTITY> {
    private final String email;

    @Override
    public Predicate toPredicate(Root<ENTITY> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<String> enailPath = root.get("email");
        return criteriaBuilder.equal(enailPath, email);
    }
}