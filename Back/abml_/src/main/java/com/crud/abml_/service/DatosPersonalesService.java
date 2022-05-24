
package com.crud.abml_.service;

import com.crud.abml_.model.DatosPersonales;
import com.crud.abml_.repository.iDatosPersonalesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatosPersonalesService implements IDatosPersonalesService {

    @Autowired
    public iDatosPersonalesRepository datosRepo;
    
    @Override
    public List<DatosPersonales> verDatosPersonales() {
        return datosRepo.findAll();
    }
    
    public Optional<DatosPersonales> getOne(int id){
        return datosRepo.findById(id);
    }
    
    public Optional<DatosPersonales> getByApellido(String apellido){
        return datosRepo.findByApellido(apellido);
    }

    @Override
    public void cargarDatosPersonales(DatosPersonales datos) {
        datosRepo.save(datos);
    }

    @Override
    public void eliminarDatosPersonales(int id) {
        datosRepo.deleteById(id);
    }
    
    public void eliminarDatosPersonales(DatosPersonales datos) {
        datosRepo.delete(datos);
    }
    
    public boolean existsById(int id) {
        return datosRepo.existsById(id);
    }
    
    public boolean existsByApellido(String apellido) {
        return datosRepo.existsByApellido(apellido);
    }

    @Override
    public DatosPersonales buscarDatos(int id) {
        return datosRepo.findById(id).orElse(null);
    }
    @Override
    public void modificarDatosPersonales(DatosPersonales datos){
        datosRepo.save(datos);
    }
    
}
