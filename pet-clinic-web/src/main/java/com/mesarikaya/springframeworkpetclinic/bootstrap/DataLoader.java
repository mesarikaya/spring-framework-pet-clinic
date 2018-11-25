package com.mesarikaya.springframeworkpetclinic.bootstrap;

import com.mesarikaya.springframeworkpetclinic.model.Owner;
import com.mesarikaya.springframeworkpetclinic.model.Vet;
import com.mesarikaya.springframeworkpetclinic.services.OwnerService;
import com.mesarikaya.springframeworkpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glemann");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Weston");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Michael");
        vet2.setLastName("Pepper");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Michael");
        vet3.setLastName("Pepper");
        vetService.save(vet3);

        System.out.println("Loaded vets...");


    }
}
