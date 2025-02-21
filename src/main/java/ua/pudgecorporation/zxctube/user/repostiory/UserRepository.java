package ua.pudgecorporation.zxctube.user.repostiory;

import org.springframework.data.repository.NoRepositoryBean;
import ua.pudgecorporation.zxctube.core.repository.CommonRepository;
import ua.pudgecorporation.zxctube.user.entity.User;

@NoRepositoryBean
public interface UserRepository extends CommonRepository<User> {

}
