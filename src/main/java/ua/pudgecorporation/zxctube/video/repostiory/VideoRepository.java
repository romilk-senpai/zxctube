package ua.pudgecorporation.zxctube.video.repostiory;

import org.springframework.data.repository.NoRepositoryBean;
import ua.pudgecorporation.zxctube.core.repository.CommonRepository;
import ua.pudgecorporation.zxctube.video.entity.Video;

@NoRepositoryBean
public interface VideoRepository extends CommonRepository<Video> {

}
