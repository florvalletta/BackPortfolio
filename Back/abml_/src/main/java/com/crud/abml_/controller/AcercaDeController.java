
package com.crud.abml_.controller;

import com.crud.abml_.dto.AcercaDeDto;
import com.crud.abml_.dto.Mensaje;
import com.crud.abml_.model.AcercaDe;
import com.crud.abml_.service.AcercaDeService;
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
@RequestMapping("/acercaDe")
@CrossOrigin(origins = "https://florenciavportfolio.web.app")
public class AcercaDeController {
    
    @Autowired
    AcercaDeService descServ;
    
    @GetMapping("/mostrar")
    @ResponseBody
    public ResponseEntity<List<AcercaDe>> verAcercaDe(){
        List<AcercaDe> verAcercaDe = descServ.verAcercaDe();
        return new ResponseEntity<List<AcercaDe>>(verAcercaDe, HttpStatus.OK);
    }
    @GetMapping("/detalle/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id") int id){
        if(!descServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        AcercaDe acerca = descServ.getOne(id).get();
        return new ResponseEntity<AcercaDe>(acerca, HttpStatus.OK);
    }
    
    @GetMapping("/detalleDesc/{descripcion}")
    public ResponseEntity<AcercaDe> getByDescripcion(@PathVariable("descripcion") String descripcion){
        if(!descServ.existsByDescripcion(descripcion))
            return new ResponseEntity(new Mensaje("no existe esa descripción"), HttpStatus.NOT_FOUND);
        AcercaDe acerca = descServ.getByDescripcion(descripcion).get();
        return new ResponseEntity<AcercaDe>(acerca, HttpStatus.OK);
    }
    
    @PostMapping("/nueva")
    public ResponseEntity<?> cargarAcercaDe(@RequestBody AcercaDeDto acercaDto) {
        if(StringUtils.isBlank(acercaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("Debe cargarse una descripción"), HttpStatus.BAD_REQUEST);
        if(descServ.existsByDescripcion(acercaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción ya existe"), HttpStatus.BAD_REQUEST);
        AcercaDe acerca = new AcercaDe(acercaDto.getDescripcion());
        descServ.cargarAcercaDe(acerca);
        return new ResponseEntity(new Mensaje("Se ha cargado la descripción"), HttpStatus.OK);
    }
    
       
    @PutMapping ("/modificar/{id}")
    public ResponseEntity<?> modificarAcercaDe(@PathVariable("id") int id, @RequestBody AcercaDeDto acercaDto) {
        if(!descServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(descServ.existsByDescripcion(acercaDto.getDescripcion()) && descServ.getByDescripcion(acercaDto.getDescripcion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La descripción ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(acercaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("Debe cargarse una descripción"), HttpStatus.BAD_REQUEST);
        AcercaDe acerca = descServ.getOne(id).get();
        acerca.setDescripcion(acercaDto.getDescripcion());
        descServ.cargarAcercaDe(acerca);
        return new ResponseEntity(new Mensaje("Se ha modificado la descripción"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> eliminarAcercaDe(@PathVariable("id") int id){
        if(!descServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        descServ.eliminarAcercaDe(id);
        return new ResponseEntity(new Mensaje("Se ha eliminado la descripción"), HttpStatus.OK);
    }
    
}
