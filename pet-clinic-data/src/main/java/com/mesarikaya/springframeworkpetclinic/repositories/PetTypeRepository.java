package com.mesarikaya.springframeworkpetclinic.repositories;

import com.mesarikaya.springframeworkpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
