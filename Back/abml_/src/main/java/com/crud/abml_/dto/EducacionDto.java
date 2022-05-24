
package com.crud.abml_.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String logoEducacion;

    public EducacionDto() {
    }

    public EducacionDto(String titulo, String institucion, String fechaInicio, String fechaFin, String logoEducacion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoEducacion = logoEducacion;
    }
    
    
}
