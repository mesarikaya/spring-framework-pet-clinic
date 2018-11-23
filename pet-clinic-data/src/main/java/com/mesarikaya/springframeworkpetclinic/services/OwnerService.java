package com.mesarikaya.springframeworkpetclinic.services;

import com.mesarikaya.springframeworkpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
