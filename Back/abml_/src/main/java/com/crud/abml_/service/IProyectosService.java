
package com.crud.abml_.service;

import com.crud.abml_.model.Proyectos;
import java.util.List;


public interface IProyectosService {
    public List<Proyectos> verProyecto();
    
    public void cargarProyecto(Proyectos proy);
    
    public void eliminarProyecto(int id);
    
    public Proyectos buscarProyecto(int id);
    
    public void modificarProyecto(Proyectos proy);
}
