package milos.springframework.milospetclinic.repositories;

import milos.springframework.milospetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
