
package com.crud.abml_.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillDto {
    @NotBlank
    private String nombreSkill;
    @Min(0)
    private int valorPorcentaje;

    public SkillDto() {
    }

    public SkillDto(String nombreSkill, int valorPorcentaje) {
        this.nombreSkill = nombreSkill;
        this.valorPorcentaje = valorPorcentaje;
    }
    
    
}
