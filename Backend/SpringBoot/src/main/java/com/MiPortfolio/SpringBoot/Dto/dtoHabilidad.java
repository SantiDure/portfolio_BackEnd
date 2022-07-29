
package com.MiPortfolio.SpringBoot.Dto;

public class dtoHabilidad {
  
    private String nombre;
    private String tiempoDeExperiencia;
    private Long porcentaje;
    
    //Constructor

    public dtoHabilidad() {
    }

    public dtoHabilidad(String nombre, String tiempoDeExperiencia, Long porcentaje) {
        this.nombre = nombre;
        this.tiempoDeExperiencia = tiempoDeExperiencia;
        this.porcentaje = porcentaje;
    }
    
    //Getter & Setter

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
