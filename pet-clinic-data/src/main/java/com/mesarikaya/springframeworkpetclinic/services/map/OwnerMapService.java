package com.mesarikaya.springframeworkpetclinic.services.map;

import com.mesarikaya.springframeworkpetclinic.model.Owner;
import com.mesarikaya.springframeworkpetclinic.model.Pet;
import com.mesarikaya.springframeworkpetclinic.services.OwnerService;
import com.mesarikaya.springframeworkpetclinic.services.PetService;
import com.mesarikaya.springframeworkpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null){
            if(object.getPet()!=null){
                object.getPet().forEach(pet->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                        if (pet.getId() == null){
                            Pet savedPet = petService.save(pet);
                            savedPet.setId(savedPet.getId());
                        }
                    }else{
                        throw new RuntimeException("Pet is required");
                    }
                });
            }
            return super.save(object.getId(), object);
        }else{
            return null;
        }


    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);
    }
}
