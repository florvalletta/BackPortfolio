
package com.crud.abml_.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class AcercaDeDto {
    @NotBlank
    private String descripcion;

    public AcercaDeDto() {
    }

    public AcercaDeDto(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
