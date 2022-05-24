
package com.crud.abml_.service;

import com.crud.abml_.model.DatosPersonales;
import java.util.List;


public interface IDatosPersonalesService {
    public List<DatosPersonales> verDatosPersonales();
    
    public void cargarDatosPersonales(DatosPersonales datos);
    
    public void eliminarDatosPersonales(int id);
    
    public DatosPersonales buscarDatos(int id);
    
    public void modificarDatosPersonales(DatosPersonales datos);
}
