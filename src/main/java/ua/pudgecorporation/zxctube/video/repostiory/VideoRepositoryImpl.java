package ua.pudgecorporation.zxctube.video.repostiory;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ua.pudgecorporation.zxctube.core.repository.CommonRepositoryImpl;
import ua.pudgecorporation.zxctube.video.entity.Video;

@Repository
public class VideoRepositoryImpl extends CommonRepositoryImpl<Video> implements VideoRepository {
    public VideoRepositoryImpl(EntityManager entityManager) {
        super(Video.class, entityManager);
    }
}
