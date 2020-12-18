package milos.springframework.milospetclinic.services;

import milos.springframework.milospetclinic.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
