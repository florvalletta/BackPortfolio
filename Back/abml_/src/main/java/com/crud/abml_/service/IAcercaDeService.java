
package com.crud.abml_.service;

import com.crud.abml_.model.AcercaDe;
import java.util.List;


public interface IAcercaDeService {
    public List<AcercaDe> verAcercaDe();
    
    public void cargarAcercaDe(AcercaDe desc);
    
    public void eliminarAcercaDe(int id);
    
    public AcercaDe buscarAcercaDe(int id);
    
    public void modificarAcercaDe(AcercaDe desc);
}
