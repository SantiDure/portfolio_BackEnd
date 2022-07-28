
package com.MiPortfolio.SpringBoot.Dto;


public class dtoPersona {
    
    private String nombre;
    
    private String apellido;
    
    private String email;
    
    private String urlFoto;
    
    private String presentacion;
    
    private String telefono;
    
    //Constructores

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String email, String urlFoto, String presentacion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.urlFoto = urlFoto;
        this.presentacion = presentacion;
        this.telefono = telefono;
    }

    
    
    //Getters & Setters

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

    
    
}
