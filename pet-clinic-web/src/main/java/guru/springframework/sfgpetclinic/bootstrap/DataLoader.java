package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        System.out.println("--------------Loaded PetType...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Rajendra");
        owner1.setLastName("Chavan");
        owner1.setAddress("Borivali");
        owner1.setCity("Mumbai");
        owner1.setTelephone("9619980626");

        Pet ownersPet1 = new Pet();
        ownersPet1.setPetType(savedDogPetType);
        ownersPet1.setOwner(owner1);
        ownersPet1.setBirthDate(LocalDate.now());
        ownersPet1.setName("Rosco");
        owner1.getPets().add(ownersPet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shailesh");
        owner2.setLastName("Mhadaye");
        owner2.setAddress("Nahur");
        owner2.setCity("Mumbai");
        owner2.setTelephone("6260899169");

        Pet ownersPet2 = new Pet();
        ownersPet2.setPetType(savedDogPetType);
        ownersPet2.setOwner(owner1);
        ownersPet2.setBirthDate(LocalDate.now());
        ownersPet2.setName("Rosco");
        owner2.getPets().add(ownersPet2);

        ownerService.save(owner2);
        System.out.println("--------------Loaded Owners....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Snehal");
        vet1.setLastName("Shelke");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Ankita");
        vet2.setLastName("Redij");

        vetService.save(vet2);
        System.out.println("--------------Loaded Vets...");
    }
}