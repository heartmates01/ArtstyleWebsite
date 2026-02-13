package nl.heartmates01.ArtstyleWebsite.medium;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mediums", path = "mediums")
public interface MediumRepository extends PagingAndSortingRepository<Medium, Long>,
    CrudRepository<Medium, Long> {

  List<Medium> findByType(@Param("type") String type);

  Medium findById(long id);
}
