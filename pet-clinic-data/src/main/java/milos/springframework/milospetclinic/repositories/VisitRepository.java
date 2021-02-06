package milos.springframework.milospetclinic.repositories;

import milos.springframework.milospetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
