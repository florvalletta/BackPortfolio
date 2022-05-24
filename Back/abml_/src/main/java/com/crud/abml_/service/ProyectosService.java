
package com.crud.abml_.service;

import com.crud.abml_.model.Proyectos;
import com.crud.abml_.repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectosService implements IProyectosService {

    @Autowired
    public ProyectosRepository proyRepo;
    
    @Override
    public List<Proyectos> verProyecto() {
        return proyRepo.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return proyRepo.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto){
        return proyRepo.findByNombreProyecto(nombreProyecto);
    }

    @Override
    public void cargarProyecto(Proyectos proy) {
        proyRepo.save(proy);
    }

    @Override
    public void eliminarProyecto(int id) {
        proyRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return proyRepo.existsById(id);
    }
    
    public boolean existsByNombreProyecto(String nombreProyecto) {
        return proyRepo.existsByNombreProyecto(nombreProyecto);
    }

    @Override
    public Proyectos buscarProyecto(int id) {
        return proyRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarProyecto(Proyectos proy) {
        proyRepo.save(proy);
    }
    
}
