
package com.crud.abml_.service;

import com.crud.abml_.model.Experiencia;
import com.crud.abml_.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService {

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencia() {
        return expRepo.findAll();
    }
    public Optional<Experiencia> getOne(int id){
        return expRepo.findById(id);
    }
    
    public Optional<Experiencia> getByPuesto(String puesto){
        return expRepo.findByPuesto(puesto);
    }
    
    @Override
    public void cargarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void eliminarExperiencia(int id) {
        expRepo.deleteById(id);
    }
    
    public void eliminarExperiencia(Experiencia exp) {
        expRepo.delete(exp);
    }
    
    public boolean existsById(int id) {
        return expRepo.existsById(id);
    }
    
    public boolean existsByPuesto(String puesto) {
        return expRepo.existsByPuesto(puesto);
    }
    
    @Override
    public Experiencia buscarExperiencia(int id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }
    
}
