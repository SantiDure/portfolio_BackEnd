
package com.MiPortfolio.SpringBoot.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @NotNull
    private String nombre;
    private String tiempoDeExperiencia;
    private Long porcentaje;
    
    //Constructor 
    public Habilidad(){
}

    public Habilidad(String nombre, String tiempoDeExperiencia, Long porcentaje) {
        this.nombre = nombre;
        this.tiempoDeExperiencia = tiempoDeExperiencia;
        this.porcentaje = porcentaje;
    }
 
    
    
    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempoDeExperiencia() {
        return tiempoDeExperiencia;
    }

    public void setTiempoDeExperiencia(String tiempoDeExperiencia) {
        this.tiempoDeExperiencia = tiempoDeExperiencia;
    }

    public Long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }

    
    
}
