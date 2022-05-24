
package com.crud.abml_.service;

import com.crud.abml_.model.Skill;
import com.crud.abml_.repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillService implements ISkillService {

    @Autowired
    SkillRepository skillRepo;
    
    @Override
    public List<Skill> verSkill() {
        return skillRepo.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return skillRepo.findById(id);
    }
    
    public Optional<Skill> getByNombreSkill(String nombreSkill){
        return skillRepo.findByNombreSkill(nombreSkill);
    }

    @Override
    public void cargarSkill(Skill ski) {
        skillRepo.save(ski);
    }

    @Override
    public void eliminarSkill(int id) {
        skillRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return skillRepo.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkill) {
        return skillRepo.existsByNombreSkill(nombreSkill);
    }

    @Override
    public Skill buscarSkill(int id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarSkill(Skill ski) {
        skillRepo.save(ski);
    }
    
}
