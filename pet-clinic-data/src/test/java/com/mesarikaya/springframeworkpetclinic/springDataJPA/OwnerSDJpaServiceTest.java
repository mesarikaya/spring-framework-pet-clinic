package com.mesarikaya.springframeworkpetclinic.springDataJPA;

import com.mesarikaya.springframeworkpetclinic.model.Owner;
import com.mesarikaya.springframeworkpetclinic.repositories.OwnerRepository;
import com.mesarikaya.springframeworkpetclinic.repositories.PetRepository;
import com.mesarikaya.springframeworkpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName("Smith").build();

        Mockito.when(ownerSDJpaService.findByLastName(ArgumentMatchers.any())).thenReturn(returnOwner);
        ownerSDJpaService.findByLastName("Smith");

        Owner smith = ownerSDJpaService.findByLastName("Smith");
        Assertions.assertEquals("Smith", smith.getLastName());
    }


    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}