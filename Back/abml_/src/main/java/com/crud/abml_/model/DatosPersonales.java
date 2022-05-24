
package com.crud.abml_.model;

import com.crud.abml_.security.models.User;
import java.io.Serializable;
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
@Table(name="datosPersonales")
public class DatosPersonales implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre", length=45, nullable=false)
    private String nombre;
    @Column(name="apellido", length=45, nullable=false)
    private String apellido;
    @Column(name="fotoPerfil", length=200, nullable=false)
    private String fotoPerfil;
    @Column(name="fotoPortada", length=200, nullable=false)
    private String fotoPortada;
    @Column(name="puestoActual", length=100, nullable=false)
    private String puestoActual;
    @Column(name="ubicacion", length=100, nullable=false)
    private String ubicacion;
    
    @OneToOne(mappedBy = "datosPersonales")
    private User user;
    

    public DatosPersonales() {
    }

    public DatosPersonales(int id, String nombre, String apellido, String fotoPerfil, String fotoPortada, String puestoActual, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
        this.puestoActual = puestoActual;
        this.ubicacion = ubicacion;
    }

    public DatosPersonales(String nombre, String apellido, String fotoPerfil, String fotoPortada, String puestoActual, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
        this.puestoActual = puestoActual;
        this.ubicacion = ubicacion;
    }
    
    
}

