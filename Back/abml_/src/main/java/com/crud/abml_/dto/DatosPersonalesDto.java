
package com.crud.abml_.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DatosPersonalesDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String fotoPerfil;
    @NotBlank
    private String fotoPortada;
    @NotBlank
    private String puestoActual;
    @NotBlank
    private String ubicacion;

    public DatosPersonalesDto() {
    }

    public DatosPersonalesDto(String nombre, String apellido, String fotoPerfil, String fotoPortada, String puestoActual, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
        this.puestoActual = puestoActual;
        this.ubicacion = ubicacion;
    }
    
    
}
