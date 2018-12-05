package com.mesarikaya.springframeworkpetclinic.repositories;

import com.mesarikaya.springframeworkpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    public Vet findByLastName(String lastName);
}
