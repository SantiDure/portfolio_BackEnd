
package com.MiPortfolio.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Persona {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    
    private String nombre;
    private String apellido;
    private String email;
    private String urlFoto;
    private String presentacion;
    private String telefono;
    private String tituloProfesional;
    
    //Constructor

    public Persona() {
    }

    public Persona(String nombre, String apellido, String email, String urlFoto, String presentacion, String telefono, String tituloProfesional) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.urlFoto = urlFoto;
        this.presentacion = presentacion;
        this.telefono = telefono;
        this.tituloProfesional = tituloProfesional;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }
    

}
