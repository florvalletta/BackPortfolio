
package com.crud.abml_.security.repository;


import com.crud.abml_.security.models.ERole;
import com.crud.abml_.security.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
