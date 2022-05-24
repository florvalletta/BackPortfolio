
package com.crud.abml_.repository;

import com.crud.abml_.model.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Integer>{
    Optional<AcercaDe> findByDescripcion(String descripcion);
    boolean existsByDescripcion(String descripcion);
    
}
