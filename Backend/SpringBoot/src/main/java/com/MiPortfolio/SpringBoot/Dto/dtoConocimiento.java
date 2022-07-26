
package com.MiPortfolio.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;


public class dtoConocimiento {
     @NotBlank
    private String nombreC;
     
     //Constructores

    public dtoConocimiento() {
    }

    public dtoConocimiento(String nombreC) {
        this.nombreC = nombreC;
    }
     //Getters & Setters

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }
    
    
     
}
