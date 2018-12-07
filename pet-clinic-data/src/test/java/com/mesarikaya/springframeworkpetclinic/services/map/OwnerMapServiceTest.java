package com.mesarikaya.springframeworkpetclinic.services.map;

import com.mesarikaya.springframeworkpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerID = 1L;
    final String lastName = "TestLastName"

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerID).build());
        ownerMapService.save(Owner.builder().lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Owner testLastName = ownerMapService.findByLastName(lastName);

        assertNotNull(testLastName);
        assertEquals(ownerID, testLastName.getId());
    }

    @Test
    void findAll()  {
        Set<Owner> ownerSet =  ownerMapService.findAll();

        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);

        assertEquals(ownerID, owner.getId());

    }

    @Test
    void save() {

    }

    @Test
    void saveNoId(){
        long id = 2L;
        Owner savedOwner = ownerMapService.save(Owner.builder().id(id).build());

        assertNull(savedOwner);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteByID(ownerID);
        assertEquals(0,ownerMapService.findAll().size());
    }
}