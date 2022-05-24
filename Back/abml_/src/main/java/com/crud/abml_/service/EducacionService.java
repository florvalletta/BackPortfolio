
package com.crud.abml_.service;

import com.crud.abml_.model.Educacion;
import com.crud.abml_.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return eduRepo.findById(id);
    }

    public Optional<Educacion> getByTitulo(String titulo){
        return eduRepo.findByTitulo(titulo);
    }
    
    @Override
    public void cargarEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void eliminarEducacion(int id) {
        eduRepo.deleteById(id);
    }
    
    public void eliminarEducacion(Educacion edu) {
        eduRepo.delete(edu);
    }
    
    public boolean existsById(int id) {
        return eduRepo.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo) {
        return eduRepo.existsByTitulo(titulo);
    }

    @Override
    public Educacion buscarEducacion(int id) {
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarEducacion(Educacion edu) {
        eduRepo.save(edu);
    }
    
}
