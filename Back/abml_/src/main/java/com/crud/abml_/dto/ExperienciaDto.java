
package com.crud.abml_.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    @NotBlank
    private String puesto;
    @NotBlank
    private String lugarTrabajo;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String logoEmpresa;
    @NotBlank
    private String descripcion;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String puesto, String lugarTrabajo, String fechaInicio, String fechaFin, String logoEmpresa, String descripcion) {
        this.puesto = puesto;
        this.lugarTrabajo = lugarTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoEmpresa = logoEmpresa;
        this.descripcion = descripcion;
    }

    

}
