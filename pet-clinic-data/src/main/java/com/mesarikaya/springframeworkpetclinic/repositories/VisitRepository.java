package com.mesarikaya.springframeworkpetclinic.repositories;

import com.mesarikaya.springframeworkpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
