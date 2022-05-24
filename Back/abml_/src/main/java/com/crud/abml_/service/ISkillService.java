
package com.crud.abml_.service;

import com.crud.abml_.model.Skill;
import java.util.List;


public interface ISkillService {
    public List<Skill> verSkill();
    
    public void cargarSkill(Skill ski);
    
    public void eliminarSkill(int id);
    
    public Skill buscarSkill(int id);
    
    public void modificarSkill(Skill ski);
}
