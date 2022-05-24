
package com.crud.abml_.model;

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
@Table(name="Experiencia")
public class Experiencia {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="puesto", length=45, nullable=false)
    private String puesto;
    @Column(name="lugarTrabajo", length=45, nullable=false)
    private String lugarTrabajo;
    @Column(name="fechaInicio", length=4, nullable=false)
    private String fechaInicio;
    @Column(name="fechaFin", length=20, nullable=false)
    private String fechaFin;
    @Column(name="logoEmpresa", length=200, nullable=false)
    private String logoEmpresa;
    @Column(name="descripcion", length=200, nullable=false)
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(int id, String puesto, String lugarTrabajo, String fechaInicio, String fechaFin, String logoEmpresa, String descripcion) {
        this.id = id;
        this.puesto = puesto;
        this.lugarTrabajo = lugarTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoEmpresa = logoEmpresa;
        this.descripcion = descripcion;
    }

    public Experiencia(String puesto, String lugarTrabajo, String fechaInicio, String fechaFin, String logoEmpresa, String descripcion) {
        this.puesto = puesto;
        this.lugarTrabajo = lugarTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoEmpresa = logoEmpresa;
        this.descripcion = descripcion;
    }
    
    
    
    
}
