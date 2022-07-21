
package com.MiPortfolio.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEstudio {
     @NotBlank
    private String nombreEst;
    @NotBlank
    private String especializacion;
    
    //Constructores

    public dtoEstudio(String nombreEst, String especializacion) {
        this.nombreEst = nombreEst;
        this.especializacion = especializacion;
    }
    
    //Getters & Setters

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
    
    
}
