
package com.crud.abml_.service;

import com.crud.abml_.model.AcercaDe;
import com.crud.abml_.repository.AcercaDeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcercaDeService implements IAcercaDeService {
    
    @Autowired
    public AcercaDeRepository descRepo;

    @Override
    public List<AcercaDe> verAcercaDe() {
        return descRepo.findAll();
    }
    
    public Optional<AcercaDe> getOne(int id){
        return descRepo.findById(id);
    }

    public Optional<AcercaDe> getByDescripcion(String descripcion){
        return descRepo.findByDescripcion(descripcion);
    }
    
    @Override
    public void cargarAcercaDe(AcercaDe desc) {
        descRepo.save(desc);
    }

    @Override
    public void eliminarAcercaDe(int id) {
        descRepo.deleteById(id);
    }
    
    public void eliminarAcercaDe(AcercaDe desc) {
        descRepo.delete(desc);
    }
    
    public boolean existsById(int id) {
        return descRepo.existsById(id);
    }
    
    public boolean existsByDescripcion(String descripcion) {
        return descRepo.existsByDescripcion(descripcion);
    }

    @Override
    public AcercaDe buscarAcercaDe(int id) {
        return descRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarAcercaDe(AcercaDe desc) {
        descRepo.save(desc);
    }
    
}
