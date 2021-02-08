package milos.springframework.milospetclinic.bootstrap;

import milos.springframework.milospetclinic.model.*;
import milos.springframework.milospetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Loading PetType list ....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Milos");
        owner1.setLastName("Milivojevic");
        owner1.setAddress("Dragojevac bb");
        owner1.setCity("Arilje");
        owner1.setTelephone("424213213");



        Pet milosevPet = new Pet();
        milosevPet.setPetType(savedDogPetType);
        milosevPet.setOwner(owner1);
        milosevPet.setBirthDate(LocalDate.now());
        milosevPet.setName("Todor");
        owner1.getPets().add(milosevPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Aleksandra");
        owner2.setLastName("Milivojevic");
        owner2.setAddress("Jasna Poljana 2B");
        owner2.setCity("Arilje");
        owner2.setTelephone("434234235555");

        Pet aleksandrinPet = new Pet();
        aleksandrinPet.setPetType(savedCatPetType);
        aleksandrinPet.setOwner(owner2);
        aleksandrinPet.setBirthDate(LocalDate.now());
        aleksandrinPet.setName("Macka");
        owner2.getPets().add(aleksandrinPet);
        ownerService.save(owner2);


        System.out.println("Loading Owners ....");

        Visit catVisit = new Visit();
        catVisit.setPet(aleksandrinPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loading Visits ....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Aco");
        vet1.setLastName("Alempijevic");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Dragica");
        vet2.setLastName("Alempijevic");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);


        System.out.println("Loading Vets ....");
    }
}
