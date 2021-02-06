package milos.springframework.milospetclinic.repositories;

import milos.springframework.milospetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
