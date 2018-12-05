package com.mesarikaya.springframeworkpetclinic.repositories;

import com.mesarikaya.springframeworkpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
