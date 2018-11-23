package com.mesarikaya.springframeworkpetclinic.services;

import com.mesarikaya.springframeworkpetclinic.model.Pet;
import com.mesarikaya.springframeworkpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lasName);
    Vet findById(Long id);
    Vet save(Pet vet);
    Set<Vet> findAll();
}
