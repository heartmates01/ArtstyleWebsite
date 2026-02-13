package nl.heartmates01.ArtstyleWebsite.artstyle;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artstyles", path = "artstyles")
public interface ArtstyleRepository extends PagingAndSortingRepository<Artstyle, Long>,
    CrudRepository<Artstyle, Long> {

  List<Artstyle> findByStyle(@Param("style") String style);

  Artstyle findById(long id);

}
