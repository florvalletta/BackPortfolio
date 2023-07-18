
package com.crud.abml_.controller;

import com.crud.abml_.dto.EducacionDto;
import com.crud.abml_.dto.Mensaje;
import com.crud.abml_.model.Educacion;
import com.crud.abml_.service.EducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "https://florenciavportfolio.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    private EducacionService eduServ;
    
    @PostMapping("/nueva")
    public ResponseEntity<?> cargarEducacion(@RequestBody EducacionDto educacionDto) {
        if(StringUtils.isBlank(educacionDto.getTitulo()))
            return new ResponseEntity(new Mensaje("Debe cargarse un título"), HttpStatus.BAD_REQUEST);
        if(eduServ.existsByTitulo(educacionDto.getTitulo()))
            return new ResponseEntity(new Mensaje("El título ya existe"), HttpStatus.BAD_REQUEST);
        Educacion edu = new Educacion(educacionDto.getTitulo(), educacionDto.getInstitucion(), educacionDto.getFechaInicio(), educacionDto.getFechaFin(), educacionDto.getLogoEducacion());
        eduServ.cargarEducacion(edu);
        return new ResponseEntity(new Mensaje("Se ha cargado correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public ResponseEntity<List<Educacion>> verEducacion(){
        List<Educacion> verEducacion = eduServ.verEducacion();
        return new ResponseEntity<List<Educacion>>(verEducacion, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!eduServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion edu = eduServ.getOne(id).get();
        return new ResponseEntity<Educacion>(edu, HttpStatus.OK);
    }
    @GetMapping("/detalleEdu/{titulo}")
    public ResponseEntity<Educacion> getByTitulo(@PathVariable("titulo") String titulo){
        if(!eduServ.existsByTitulo(titulo))
            return new ResponseEntity(new Mensaje("no existe ese título"), HttpStatus.NOT_FOUND);
        Educacion edu = eduServ.getByTitulo(titulo).get();
        return new ResponseEntity<Educacion>(edu, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> eliminarEducacion(@PathVariable("id") int id){
        if(!eduServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        eduServ.eliminarEducacion(id);
        return new ResponseEntity(new Mensaje("Se ha eliminado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/modificar/{id}")
    public ResponseEntity<?> modificarEducacion(@PathVariable("id") int id, @RequestBody EducacionDto educacionDto) {
        if(!eduServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(eduServ.existsByTitulo(educacionDto.getTitulo()) && eduServ.getByTitulo(educacionDto.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese título ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getTitulo()))
            return new ResponseEntity(new Mensaje("Debe cargarse un título"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("Debe cargarse una institución"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getFechaInicio()))
            return new ResponseEntity(new Mensaje("Debe cargarse una fecha de inicio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getFechaFin()))
            return new ResponseEntity(new Mensaje("Debe cargarse una fecha de fin o, en su defecto, poner Actualidad"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getLogoEducacion()))
            return new ResponseEntity(new Mensaje("Debe cargarse un logo"), HttpStatus.BAD_REQUEST);
        Educacion edu = eduServ.getOne(id).get();
        edu.setTitulo(educacionDto.getTitulo());
        edu.setInstitucion(educacionDto.getInstitucion());
        edu.setFechaInicio(educacionDto.getFechaInicio());
        edu.setFechaFin(educacionDto.getFechaFin());
        edu.setLogoEducacion(educacionDto.getLogoEducacion());
        eduServ.cargarEducacion(edu);
        return new ResponseEntity(new Mensaje("Se ha modificado los datos de educación"), HttpStatus.OK);
    }
}
