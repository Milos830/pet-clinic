package milos.springframework.milospetclinic.bootstrap;

import milos.springframework.milospetclinic.model.Owner;
import milos.springframework.milospetclinic.model.PetType;
import milos.springframework.milospetclinic.model.Vet;
import milos.springframework.milospetclinic.services.OwnerService;
import milos.springframework.milospetclinic.services.PetTypeService;
import milos.springframework.milospetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loading PetType list ....");

        Owner owner1 = new Owner();

        owner1.setFirstName("Milos");
        owner1.setLastName("Milivojevic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Aleksandra");
        owner2.setLastName("Milivojevic");
        ownerService.save(owner2);

        System.out.println("Loading Owners ....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Aco");
        vet1.setLastName("Alempijevic");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Dragica");
        vet2.setLastName("Alempijevic");
        vetService.save(vet2);

        System.out.println("Loading Vets ....");
    }
}
