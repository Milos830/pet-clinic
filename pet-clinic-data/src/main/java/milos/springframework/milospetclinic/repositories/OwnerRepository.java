package milos.springframework.milospetclinic.repositories;

import milos.springframework.milospetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
