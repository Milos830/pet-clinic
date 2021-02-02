package milos.springframework.milospetclinic.bootstrap;

import milos.springframework.milospetclinic.model.Owner;
import milos.springframework.milospetclinic.model.Vet;
import milos.springframework.milospetclinic.services.OwnerService;
import milos.springframework.milospetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Milos");
        owner1.setLastName("Milivojevic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Aleksandra");
        owner2.setLastName("Milivojevic");
        ownerService.save(owner2);

        System.out.println("Loading Owners ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Aco");
        vet1.setLastName("Alempijevic");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Dragica");
        vet2.setLastName("Alempijevic");
        vetService.save(vet2);

        System.out.println("Loading Vets ....");
    }
}
