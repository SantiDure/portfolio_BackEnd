
package com.MiPortfolio.SpringBoot.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @NotNull
    private String nombre;
    private String tiempoDeExperiencia;
    
    
    public Habilidad(){
}
 
    public Habilidad(Long id, String nombre, String tiempoDeExperiencia){
    this.id = id;
    this.nombre = nombre;
    this.tiempoDeExperiencia = tiempoDeExperiencia;
    }

}
