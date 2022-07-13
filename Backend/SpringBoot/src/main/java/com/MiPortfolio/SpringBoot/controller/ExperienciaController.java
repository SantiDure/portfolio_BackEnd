
package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.model.Experiencia;
import com.MiPortfolio.SpringBoot.service.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    public IExperienciaService expeServ;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/new/experiencia")
    public void agregarExperiencia (@RequestBody Experiencia exp) {
    expeServ.crearExperiencia(exp);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/ver/experiencias")
    @ResponseBody
    public List<Experiencia> verExperiencias(){
    return expeServ.verExperiencias();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/experiencia/{id}")
    public void borrarExperiencia (@PathVariable Long id){
    expeServ.borrarExperiencia(id);
    }


}
