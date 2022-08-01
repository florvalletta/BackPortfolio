
package com.crud.abml_.controller;

import com.crud.abml_.dto.ExperienciaDto;
import com.crud.abml_.dto.Mensaje;
import com.crud.abml_.model.Experiencia;
import com.crud.abml_.service.ExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://florenciavportfolio.web.app")
//@CrossOrigin(origins = "http://localhost:4200/")
public class ExperienciaController {
    
    @Autowired
    private ExperienciaService expServ;
    
    @PostMapping("/nueva")
    public ResponseEntity<?> cargarExperiencia(@RequestBody ExperienciaDto experienciaDto) {
        if(StringUtils.isBlank(experienciaDto.getPuesto()))
            return new ResponseEntity(new Mensaje("Debe cargarse un puesto"), HttpStatus.BAD_REQUEST);
        if(expServ.existsByPuesto(experienciaDto.getPuesto()))
            return new ResponseEntity(new Mensaje("El puesto ya existe"), HttpStatus.BAD_REQUEST);
        Experiencia exp = new Experiencia(experienciaDto.getPuesto(), experienciaDto.getLugarTrabajo(), experienciaDto.getFechaInicio(), experienciaDto.getFechaFin(), experienciaDto.getLogoEmpresa(), experienciaDto.getDescripcion());
        expServ.cargarExperiencia(exp);
        return new ResponseEntity(new Mensaje("Se ha cargado correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public ResponseEntity<List<Experiencia>> verExperiencia(){
        List<Experiencia> verExperiencia = expServ.verExperiencia();
        return new ResponseEntity<List<Experiencia>>(verExperiencia, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia exp = expServ.getOne(id).get();
        return new ResponseEntity<Experiencia>(exp, HttpStatus.OK);
    }
    @GetMapping("/detalleExp/{puesto}")
    public ResponseEntity<Experiencia> getByPuesto(@PathVariable("puesto") String puesto){
        if(!expServ.existsByPuesto(puesto))
            return new ResponseEntity(new Mensaje("no existe ese puesto"), HttpStatus.NOT_FOUND);
        Experiencia exp = expServ.getByPuesto(puesto).get();
        return new ResponseEntity<Experiencia>(exp, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> eliminarExperiencia(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        expServ.eliminarExperiencia(id);
        return new ResponseEntity(new Mensaje("Se ha eliminado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/modificar/{id}")
    public ResponseEntity<?> modificarEducacion(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto) {
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(expServ.existsByPuesto(experienciaDto.getPuesto()) && expServ.getByPuesto(experienciaDto.getPuesto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese puesto ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getPuesto()))
            return new ResponseEntity(new Mensaje("Debe cargarse un puesto"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getLugarTrabajo()))
            return new ResponseEntity(new Mensaje("Debe cargarse un lugar de trabajo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getFechaInicio()))
            return new ResponseEntity(new Mensaje("Debe cargarse una fecha de inicio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getFechaFin()))
            return new ResponseEntity(new Mensaje("Debe cargarse una fecha de fin o, en su defecto, poner Actualidad"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getLogoEmpresa()))
            return new ResponseEntity(new Mensaje("Debe cargarse un logo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("Debe cargarse una descripción"), HttpStatus.BAD_REQUEST);
        Experiencia exp = expServ.getOne(id).get();
        exp.setPuesto(experienciaDto.getPuesto());
        exp.setLugarTrabajo(experienciaDto.getLugarTrabajo());
        exp.setFechaInicio(experienciaDto.getFechaInicio());
        exp.setFechaFin(experienciaDto.getFechaFin());
        exp.setLogoEmpresa(experienciaDto.getLogoEmpresa());
        exp.setDescripcion(experienciaDto.getDescripcion());
        expServ.cargarExperiencia(exp);
        return new ResponseEntity(new Mensaje("Se ha modificado los datos de experiencia"), HttpStatus.OK);
    }
}
