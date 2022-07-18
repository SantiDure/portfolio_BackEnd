
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
public class Persona {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @NotNull
    private String nombre;
    private String apellido;
    private String email;
    private String urlFoto;
    private String presentacion;
    private String telefono;
    
    public Persona(){
}
 
    public Persona(Long id, String nombre, String apellido, String email, String urlFoto, String presentacion, String telefono){
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.urlFoto = urlFoto;
    this.presentacion = presentacion;
    this.telefono = telefono;
    }



}
