package milos.springframework.milospetclinic.repositories;

import milos.springframework.milospetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
