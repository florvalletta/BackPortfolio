
package com.crud.abml_.controller;

import com.crud.abml_.dto.Mensaje;
import com.crud.abml_.dto.ProyectosDto;
import com.crud.abml_.model.Proyectos;
import com.crud.abml_.service.ProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://florenciavportfolio.web.app")
public class ProyectosController {
    @Autowired
    private ProyectosService proyServ;
    
    @PostMapping("/nueva")
    public ResponseEntity<?> cargarProyecto(@RequestBody ProyectosDto proyectosDto) {
        if(StringUtils.isBlank(proyectosDto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("Debe cargarse un proyecto"), HttpStatus.BAD_REQUEST);
        if(proyServ.existsByNombreProyecto(proyectosDto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        Proyectos proyecto = new Proyectos(proyectosDto.getNombreProyecto(), proyectosDto.getFechaRealizacion(), proyectosDto.getLinkProyecto(), proyectosDto.getImagenProyecto(), proyectosDto.getDescripcionProyecto());
        proyServ.cargarProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Se ha cargado correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public ResponseEntity<List<Proyectos>> verProyecto(){
        List<Proyectos> verProyecto = proyServ.verProyecto();
        return new ResponseEntity<List<Proyectos>>(verProyecto, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyecto = proyServ.getOne(id).get();
        return new ResponseEntity<Proyectos>(proyecto, HttpStatus.OK);
    }
    @GetMapping("/detalleProy/{nombreProyecto}")
    public ResponseEntity<Proyectos> getByNombreProyecto(@PathVariable("nombreProyecto") String nombreProyecto){
        if(!proyServ.existsByNombreProyecto(nombreProyecto))
            return new ResponseEntity(new Mensaje("no existe ese nombre de proyecto"), HttpStatus.NOT_FOUND);
        Proyectos proyecto = proyServ.getByNombreProyecto(nombreProyecto).get();
        return new ResponseEntity<Proyectos>(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable("id") int id){
        if(!proyServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        proyServ.eliminarProyecto(id);
        return new ResponseEntity(new Mensaje("Se ha eliminado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/modificar/{id}")
    public ResponseEntity<?> modificarProyecto(@PathVariable("id") int id, @RequestBody ProyectosDto proyectosDto) {
        if(!proyServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(proyServ.existsByNombreProyecto(proyectosDto.getNombreProyecto()) && proyServ.getByNombreProyecto(proyectosDto.getNombreProyecto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("Debe cargarse un nombre de proyecto"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getFechaRealizacion()))
            return new ResponseEntity(new Mensaje("Debe cargarse una fecha de realización"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getImagenProyecto()))
            return new ResponseEntity(new Mensaje("Debe cargarse una imagen representativa del proyecto"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getLinkProyecto()))
            return new ResponseEntity(new Mensaje("Debe cargarse un link al proyecto"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getDescripcionProyecto()))
            return new ResponseEntity(new Mensaje("Debe cargarse una descripción del proyecto"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyecto = proyServ.getOne(id).get();
        proyecto.setNombreProyecto(proyectosDto.getNombreProyecto());
        proyecto.setFechaRealizacion(proyectosDto.getFechaRealizacion());
        proyecto.setImagenProyecto(proyectosDto.getImagenProyecto());
        proyecto.setLinkProyecto(proyectosDto.getLinkProyecto());
        proyecto.setDescripcionProyecto(proyectosDto.getDescripcionProyecto());
        proyServ.cargarProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Se ha modificado el proyecto"), HttpStatus.OK);
    }
}
