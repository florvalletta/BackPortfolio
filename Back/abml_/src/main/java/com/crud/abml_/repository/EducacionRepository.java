
package com.crud.abml_.repository;

import com.crud.abml_.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducacionRepository extends JpaRepository <Educacion, Integer>{
    Optional<Educacion> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
}
