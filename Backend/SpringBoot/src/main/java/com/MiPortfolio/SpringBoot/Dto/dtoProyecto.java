
package com.MiPortfolio.SpringBoot.Dto;


public class dtoProyecto {
      private String nombre;
      private String descripcion;
      
      //Constructor 

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
      //Getter & Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
