
package com.crud.abml_.service;

import com.crud.abml_.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    
    public void cargarExperiencia(Experiencia exp);
    
    public void eliminarExperiencia(int id);
    
    public Experiencia buscarExperiencia(int id);
    
    public void modificarExperiencia(Experiencia exp);
}
