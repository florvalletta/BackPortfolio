
package com.crud.abml_.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="proyectos")
public class Proyectos implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="nombreProyecto", length=45, nullable=false)
    private String nombreProyecto;
    @Column(name="fechaRealizacion", length=4, nullable=false)
    private String fechaRealizacion;
    @Column(name="linkProyecto", length=200, nullable=false)
    private String linkProyecto;
    @Column(name="imagenProyecto", length=200, nullable=false)
    private String imagenProyecto;
    @Column(name="descripcionProyecto", length=200, nullable=false)
    private String descripcionProyecto;

    public Proyectos() {
    }

    public Proyectos(int id, String nombreProyecto, String fechaRealizacion, String linkProyecto, String imagenProyecto, String descripcionProyecto) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.fechaRealizacion = fechaRealizacion;
        this.linkProyecto = linkProyecto;
        this.imagenProyecto = imagenProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

    public Proyectos(String nombreProyecto, String fechaRealizacion, String linkProyecto, String imagenProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.fechaRealizacion = fechaRealizacion;
        this.linkProyecto = linkProyecto;
        this.imagenProyecto = imagenProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

    
    
    
    
}
