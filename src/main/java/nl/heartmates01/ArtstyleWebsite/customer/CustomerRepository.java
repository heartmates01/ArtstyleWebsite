package nl.heartmates01.ArtstyleWebsite.customer;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>,
    CrudRepository<Customer, Long> {

  List<Customer> findByFirstName(@Param("firstName") String firstName);

  List<Customer> findByLastName(@Param("lastName") String lastName);


  Customer findById(long id);
}
