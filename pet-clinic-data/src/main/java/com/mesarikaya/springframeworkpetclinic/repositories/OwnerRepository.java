package com.mesarikaya.springframeworkpetclinic.repositories;

import com.mesarikaya.springframeworkpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Owner findByLastName(String lastName);
}
