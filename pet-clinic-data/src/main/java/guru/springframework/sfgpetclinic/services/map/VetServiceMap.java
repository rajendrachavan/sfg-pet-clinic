package guru.springframework.sfgpetclinic.services.map;

import com.sun.xml.internal.bind.v2.model.core.ID;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CurdService;
import guru.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
