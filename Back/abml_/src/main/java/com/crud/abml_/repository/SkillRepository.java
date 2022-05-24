
package com.crud.abml_.repository;

import com.crud.abml_.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    Optional<Skill> findByNombreSkill(String nombreSkill);
    boolean existsByNombreSkill(String nombreSkill);
}
