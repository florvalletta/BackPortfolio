
package com.crud.abml_.model;

import com.crud.abml_.security.models.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="acercaDe")
public class AcercaDe {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="descripcion", length=240, nullable=false)
    private String descripcion;

    @OneToOne(mappedBy = "acercaDe")
    private User user;
    
    public AcercaDe() {
    }

    public AcercaDe(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public AcercaDe(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
