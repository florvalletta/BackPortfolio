
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
@Table(name="skill")
public class Skill {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="nombreSkill", length=45, nullable=false)
    private String nombreSkill;
    @Column(name="valorPorcentaje", nullable=false)
    private int valorPorcentaje;

    public Skill() {
    }

    public Skill(int id, String nombreSkill, int valorPorcentaje) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.valorPorcentaje = valorPorcentaje;
    }

    public Skill(String nombreSkill, int valorPorcentaje) {
        this.nombreSkill = nombreSkill;
        this.valorPorcentaje = valorPorcentaje;
    }
    
    
    
    
}
