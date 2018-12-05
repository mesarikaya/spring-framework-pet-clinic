package com.mesarikaya.springframeworkpetclinic.services.map;

import com.mesarikaya.springframeworkpetclinic.model.Visit;
import com.mesarikaya.springframeworkpetclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    @Autowired
    private VisitService visitService;

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }


        return super.save(visit.getId(), visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);
    }
}
