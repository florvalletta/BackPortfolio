
package com.crud.abml_.controller;

import com.crud.abml_.dto.DatosPersonalesDto;
import com.crud.abml_.dto.Mensaje;
import com.crud.abml_.model.DatosPersonales;
import com.crud.abml_.service.DatosPersonalesService;
import java.io.Serializable;
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
@RequestMapping("/datosPersonales")
@CrossOrigin(origins = "http://localhost:4200")
public class DatosPersonalesController {
    
    @Autowired
    private DatosPersonalesService datosServ;
    
    @PostMapping("/nueva")
    public ResponseEntity<?> cargarExperiencia(@RequestBody DatosPersonalesDto datosPersonalesDto) {
        if(StringUtils.isBlank(datosPersonalesDto.getApellido()))
            return new ResponseEntity(new Mensaje("Debe cargarse un apellido"), HttpStatus.BAD_REQUEST);
        if(datosServ.existsByApellido(datosPersonalesDto.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido ya existe"), HttpStatus.BAD_REQUEST);
        DatosPersonales datos = new DatosPersonales(datosPersonalesDto.getNombre(), datosPersonalesDto.getApellido(), datosPersonalesDto.getFotoPerfil(), datosPersonalesDto.getFotoPortada(), datosPersonalesDto.getPuestoActual(), datosPersonalesDto.getUbicacion());
        datosServ.cargarDatosPersonales(datos);
        return new ResponseEntity(new Mensaje("Se ha cargado correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public ResponseEntity<List<DatosPersonales>> verDatosPersonales(){
        List<DatosPersonales> verDatosPersonales = datosServ.verDatosPersonales();
        return new ResponseEntity<List<DatosPersonales>>(verDatosPersonales, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<DatosPersonales> getById(@PathVariable("id") int id){
        if(!datosServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        DatosPersonales datos = datosServ.getOne(id).get();
        return new ResponseEntity<DatosPersonales>(datos, HttpStatus.OK);
    }
    @GetMapping("/detalleDatos/{apellido}")
    public ResponseEntity<DatosPersonales> getByApellido(@PathVariable("apellido") String apellido){
        if(!datosServ.existsByApellido(apellido))
            return new ResponseEntity(new Mensaje("no existe ese apellido"), HttpStatus.NOT_FOUND);
        DatosPersonales datos = datosServ.getByApellido(apellido).get();
        return new ResponseEntity<DatosPersonales>(datos, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> eliminarDatosPersonales(@PathVariable("id") int id){
        if(!datosServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        datosServ.eliminarDatosPersonales(id);
        return new ResponseEntity(new Mensaje("Se ha eliminado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/modificar/{id}")
    public ResponseEntity<?> modificarDatosPersonales(@PathVariable("id") int id, @RequestBody DatosPersonalesDto datosPersonalesDto) {
        if(!datosServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(datosServ.existsByApellido(datosPersonalesDto.getApellido()) && datosServ.getByApellido(datosPersonalesDto.getApellido()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese apellido ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosPersonalesDto.getNombre()))
            return new ResponseEntity(new Mensaje("Debe cargarse un nombre"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosPersonalesDto.getApellido()))
            return new ResponseEntity(new Mensaje("Debe cargarse un apellido"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosPersonalesDto.getFotoPerfil()))
            return new ResponseEntity(new Mensaje("Debe cargarse una foto de perfil"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosPersonalesDto.getFotoPortada()))
            return new ResponseEntity(new Mensaje("Debe cargarse una foto de portada"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosPersonalesDto.getPuestoActual()))
            return new ResponseEntity(new Mensaje("Debe cargarse un puesto actual"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosPersonalesDto.getUbicacion()))
            return new ResponseEntity(new Mensaje("Debe cargarse una ubicación"), HttpStatus.BAD_REQUEST);
        
        DatosPersonales datos = datosServ.getOne(id).get();
        datos.setNombre(datosPersonalesDto.getNombre());
        datos.setApellido(datosPersonalesDto.getApellido());
        datos.setFotoPerfil(datosPersonalesDto.getFotoPerfil());
        datos.setFotoPortada(datosPersonalesDto.getFotoPortada());
        datos.setPuestoActual(datosPersonalesDto.getPuestoActual());
        datos.setUbicacion(datosPersonalesDto.getUbicacion());
        datosServ.cargarDatosPersonales(datos);
        return new ResponseEntity(new Mensaje("Se han modificado los datos personales"), HttpStatus.OK);
    }
}
