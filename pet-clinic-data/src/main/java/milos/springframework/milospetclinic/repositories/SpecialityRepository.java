package milos.springframework.milospetclinic.repositories;

import milos.springframework.milospetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
