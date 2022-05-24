
package com.crud.abml_.repository;

import com.crud.abml_.model.DatosPersonales;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iDatosPersonalesRepository extends JpaRepository <DatosPersonales, Integer> {
    Optional<DatosPersonales> findByApellido(String apellido);
    boolean existsByApellido(String apellido);
}
