package nl.heartmates01.ArtstyleWebsite.setting;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "settings", path = "settings")
public interface SettingRepository extends PagingAndSortingRepository<Setting, Long>,
    CrudRepository<Setting, Long> {

  List<Setting> findByType(@Param("type") String type);

  Setting findById(long id);
}
