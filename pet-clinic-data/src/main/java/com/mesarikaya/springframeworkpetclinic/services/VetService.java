package com.mesarikaya.springframeworkpetclinic.services;

import com.mesarikaya.springframeworkpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lasName);
}
