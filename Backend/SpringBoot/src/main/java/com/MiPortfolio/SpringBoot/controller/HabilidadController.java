
package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.model.Habilidad;
import com.MiPortfolio.SpringBoot.service.IHabilidadService;
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
public class HabilidadController {
    
    @Autowired
    public IHabilidadService habiServ;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/new/habilidad")
    public void agregarHabilidad (@RequestBody Habilidad habi) {
    habiServ.crearHabilidad(habi);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/ver/habilidades")
    @ResponseBody
    public List<Habilidad> verHabilidades(){
    return habiServ.verHabilidades();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/habilidad/{id}")
    public void borrarHabilidad (@PathVariable Long id){
    habiServ.borrarHabilidad(id);
    }


}


