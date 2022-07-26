
package com.MiPortfolio.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conocimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    
    private String nombreC;
    
    //Constructores

    public Conocimiento() {
    }

    public Conocimiento(String nombreC) {
        this.nombreC = nombreC;
    }
    
    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }
    
    
}
