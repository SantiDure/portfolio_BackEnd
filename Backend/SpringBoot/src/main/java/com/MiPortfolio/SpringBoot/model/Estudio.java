
package com.MiPortfolio.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estudio {
    
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    
    private String nombreEst;
    private String especializacion;
    
    

    public Estudio(){
}
 
    public Estudio( String nombreEst, String especializacion){
    
    this.nombreEst = nombreEst;
    this.especializacion = especializacion;
    
    }

    
//Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
