package ua.pudgecorporation.zxctube.user.repostiory;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ua.pudgecorporation.zxctube.core.repository.CommonRepositoryImpl;
import ua.pudgecorporation.zxctube.user.entity.User;

@Repository
public class UserRepositoryImpl extends CommonRepositoryImpl<User> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(User.class, entityManager);
    }
}
