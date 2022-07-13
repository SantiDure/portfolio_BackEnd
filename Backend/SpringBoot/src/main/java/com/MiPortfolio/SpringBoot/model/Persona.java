
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
    private String mail;
    private String teléfono;
    private String presentación;
    private String urlFoto;
    
    public Persona(){
}
 
    public Persona(Long id, String nombre, String apellido, String mail, String teléfono, String presentación, String urlFoto){
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.mail = mail;
    this.teléfono = teléfono;
    this.presentación = presentación;
    this.urlFoto = urlFoto;
    }



}
