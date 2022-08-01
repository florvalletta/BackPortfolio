
package com.crud.abml_.model;

import com.crud.abml_.security.models.User;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="educacion")
public class Educacion implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="titulo", length=500, nullable=false)
    private String titulo;
    @Column(name="institucion", length=240, nullable=false)
    private String institucion;
    @Column(name="fechaInicio", length=4, nullable=false)
    private String fechaInicio;
    @Column(name="fechaFin", length=20, nullable=false)
    private String fechaFin;
    @Column(name="logoEducacion", length=200, nullable=false)
    private String logoEducacion;
    

    public Educacion() {
    }

    public Educacion(int id, String titulo, String institucion, String fechaInicio, String fechaFin, String logoEducacion) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoEducacion = logoEducacion;
    }

    public Educacion(String titulo, String institucion, String fechaInicio, String fechaFin, String logoEducacion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoEducacion = logoEducacion;
    }
    
    
}
