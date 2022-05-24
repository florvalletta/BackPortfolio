
package com.crud.abml_.controller;

import com.crud.abml_.dto.Mensaje;
import com.crud.abml_.dto.SkillDto;
import com.crud.abml_.model.Skill;
import com.crud.abml_.service.SkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200/")
public class SkillController {
    
    @Autowired
    private SkillService skillServ;
    
    @PostMapping("/nueva")
    public ResponseEntity<?> cargarSkill(@RequestBody SkillDto skillDto) {
        if(StringUtils.isBlank(skillDto.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Debe cargarse una skill"), HttpStatus.BAD_REQUEST);
        if(skillDto.getValorPorcentaje()<0)
            return new ResponseEntity(new Mensaje("El porcentaje no puede ser negativo"), HttpStatus.BAD_REQUEST);
        if(skillServ.existsByNombreSkill(skillDto.getNombreSkill()))
            return new ResponseEntity(new Mensaje("La skill ya existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(skillDto.getNombreSkill(), skillDto.getValorPorcentaje());
        skillServ.cargarSkill(skill);
        return new ResponseEntity(new Mensaje("Se ha cargado correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public ResponseEntity<List<Skill>> verSkill(){
        List<Skill> verSkill = skillServ.verSkill();
        return new ResponseEntity<List<Skill>>(verSkill, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillServ.getOne(id).get();
        return new ResponseEntity<Skill>(skill, HttpStatus.OK);
    }
    @GetMapping("/detalleSkill/{nombreSkill}")
    public ResponseEntity<Skill> getByNombreSkill(@PathVariable("nombreSkill") String nombreSkill){
        if(!skillServ.existsByNombreSkill(nombreSkill))
            return new ResponseEntity(new Mensaje("no existe esa skill"), HttpStatus.NOT_FOUND);
        Skill skill = skillServ.getByNombreSkill(nombreSkill).get();
        return new ResponseEntity<Skill>(skill, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> eliminarSkill(@PathVariable("id") int id){
        if(!skillServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        skillServ.eliminarSkill(id);
        return new ResponseEntity(new Mensaje("Se ha eliminado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/modificar/{id}")
    public ResponseEntity<?> modificarSkill(@PathVariable("id") int id, @RequestBody SkillDto skillDto) {
        if(!skillServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(skillServ.existsByNombreSkill(skillDto.getNombreSkill()) && skillServ.getByNombreSkill(skillDto.getNombreSkill()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Debe cargarse un nombre de skill"), HttpStatus.BAD_REQUEST);
        if(skillDto.getValorPorcentaje()<0)
            return new ResponseEntity(new Mensaje("El porcentaje no puede ser negativo"), HttpStatus.BAD_REQUEST);
        
        Skill skill = skillServ.getOne(id).get();
        skill.setNombreSkill(skillDto.getNombreSkill());
        skill.setValorPorcentaje(skillDto.getValorPorcentaje());
        skillServ.cargarSkill(skill);
        return new ResponseEntity(new Mensaje("Se han modificado los datos de skill"), HttpStatus.OK);
    }
}
