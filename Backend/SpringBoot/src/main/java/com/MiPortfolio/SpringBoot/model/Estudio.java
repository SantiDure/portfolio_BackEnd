
package com.MiPortfolio.SpringBoot.model;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Estudio {
    
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @NotNull
    private String nombreInstitución;
    private String especializacion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    

    public Estudio(){
}
 
    public Estudio(Long id, String nombreInstitución, String especialización, Date fechaInicio, Date fechaFin){
    this.id = id;
    this.nombreInstitución = nombreInstitución;
    this.especializacion = especializacion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    
    }




}
