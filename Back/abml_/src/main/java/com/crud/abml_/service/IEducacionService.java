
package com.crud.abml_.service;

import com.crud.abml_.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> verEducacion();
    
    public void cargarEducacion(Educacion edu);
    
    public void eliminarEducacion(int id);
    
    public Educacion buscarEducacion(int id);
    
    public void modificarEducacion(Educacion edu);
}
