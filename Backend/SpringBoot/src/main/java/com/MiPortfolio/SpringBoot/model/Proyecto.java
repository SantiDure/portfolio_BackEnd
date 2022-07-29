
package com.MiPortfolio.SpringBoot.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Proyecto {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @NotNull
    private String nombre;
    private String descripcion;
    
    //Constructor
    
    public Proyecto(){
}
 
    public Proyecto(String nombre, String descripcion){
  
    this.nombre = nombre;
    this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}


