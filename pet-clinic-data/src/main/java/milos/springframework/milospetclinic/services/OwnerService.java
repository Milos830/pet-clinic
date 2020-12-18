package milos.springframework.milospetclinic.services;

import milos.springframework.milospetclinic.model.Owner;

import java.util.Set;

public interface OwnerService  {

    Owner findByLastNama(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
