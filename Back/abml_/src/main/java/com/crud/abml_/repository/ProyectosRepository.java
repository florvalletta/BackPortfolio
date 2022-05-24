
package com.crud.abml_.repository;

import com.crud.abml_.model.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository <Proyectos, Integer> {
    Optional<Proyectos> findByNombreProyecto(String nombreProyecto);
    boolean existsByNombreProyecto(String nombreProyecto);
}
