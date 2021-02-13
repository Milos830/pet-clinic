package milos.springframework.milospetclinic.services.map;

import milos.springframework.milospetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByLastName() {

        Owner smith = ownerMapService.findByLastName(lastName);
        assertNotNull("smith");
        assertEquals(ownerId, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner smith = ownerMapService.findByLastName("foo");
        assertNull(smith);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(1,owner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner1 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner1);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void savedNoId() {
        Owner savedOwner = Owner.builder().build();

        assertNotNull(savedOwner);
        assertNull(savedOwner.getId());
    }
}