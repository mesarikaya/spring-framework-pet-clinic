package com.mesarikaya.springframeworkpetclinic.bootstrap;

import com.mesarikaya.springframeworkpetclinic.model.*;
import com.mesarikaya.springframeworkpetclinic.services.OwnerService;
import com.mesarikaya.springframeworkpetclinic.services.PetTypeService;
import com.mesarikaya.springframeworkpetclinic.services.SpecialtyService;
import com.mesarikaya.springframeworkpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(SpecialtyService specialtyService, OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count==0){
            loadData();
        }

    }

    private void loadData() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        specialtyService.save(surgery);

        Speciality dentristry = new Speciality();
        radiology.setDescription("Destistry");
        specialtyService.save(dentristry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glemann");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatType);
        fionasCat.setOwner(owner1);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Kattie");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Weston");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Doritos");
        vet2.setLastName("Punchos");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Michael");
        vet3.setLastName("Pepper");
        vet3.getSpecialities().add(dentristry);
        vetService.save(vet3);

        System.out.println("Loaded vets...");
    }
}
