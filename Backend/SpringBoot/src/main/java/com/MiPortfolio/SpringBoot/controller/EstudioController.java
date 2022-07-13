package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.model.Estudio;
import com.MiPortfolio.SpringBoot.service.IEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudioController {
    
    @Autowired
    public IEstudioService estuServ;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/new/estudio")
    public void agregarEstudio (@RequestBody Estudio est) {
    estuServ.crearEstudio(est);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/ver/estudios")
    @ResponseBody
    public List<Estudio> verEstudios(){
    return estuServ.verEstudios();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/estudio/{id}")
    public void borrarEstudio (@PathVariable Long id){
    estuServ.borrarEstudio(id);
    }
    
}
