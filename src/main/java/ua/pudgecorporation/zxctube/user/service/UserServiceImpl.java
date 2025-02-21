package ua.pudgecorporation.zxctube.user.service;

import org.springframework.stereotype.Service;
import ua.pudgecorporation.zxctube.core.service.CommonCrudServiceImpl;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;
import ua.pudgecorporation.zxctube.user.entity.User;
import ua.pudgecorporation.zxctube.user.mapper.UserMapper;
import ua.pudgecorporation.zxctube.user.repostiory.UserRepository;
import ua.pudgecorporation.zxctube.user.repostiory.specification.EmailSpecification;

import java.util.Optional;

@Service
public class UserServiceImpl extends CommonCrudServiceImpl<User, UserDTO> implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);

        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void updateEntity(User user, User externalEntity) {
        user.setAvatarUuid(externalEntity.getAvatarUuid());
        user.setEmail(externalEntity.getEmail());
        user.setDisplayName(externalEntity.getDisplayName());
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        Optional<User> userOpt = repository.findOne(new EmailSpecification<User>(email));

        if (userOpt.isPresent()) {
            return Optional.of(mapper.mapToDTO(userOpt.get()));
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> findByKeycloakUuid(String keycloakUuid) {
        //TODO :implement api
        return repository.findOne(new );
    }
}
