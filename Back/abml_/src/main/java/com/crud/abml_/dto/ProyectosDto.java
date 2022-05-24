
package com.crud.abml_.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectosDto {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String fechaRealizacion;
    @NotBlank
    private String linkProyecto;
    @NotBlank
    private String imagenProyecto;
    @NotBlank
    private String descripcionProyecto;

    public ProyectosDto() {
    }

    public ProyectosDto(String nombreProyecto, String fechaRealizacion, String linkProyecto, String imagenProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.fechaRealizacion = fechaRealizacion;
        this.linkProyecto = linkProyecto;
        this.imagenProyecto = imagenProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

    
    
    
}
