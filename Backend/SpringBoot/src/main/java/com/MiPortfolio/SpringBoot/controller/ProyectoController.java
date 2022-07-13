
package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.model.Proyecto;
import com.MiPortfolio.SpringBoot.service.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyServ;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/new/proyecto")
    public void agregarProyecto (@RequestBody Proyecto pro) {
    proyServ.crearProyecto(pro);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/ver/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos(){
    return proyServ.verProyectos();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/proyecto/{id}")
    public void borrarProyecto (@PathVariable Long id){
    proyServ.borrarProyecto(id);
    }
    
}
