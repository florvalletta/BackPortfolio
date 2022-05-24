
package com.crud.abml_.repository;

import com.crud.abml_.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Integer>{
    Optional<Experiencia> findByPuesto(String puesto);
    boolean existsByPuesto(String puesto);
}
