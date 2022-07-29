
package com.MiPortfolio.SpringBoot.controller;


import com.MiPortfolio.SpringBoot.Dto.dtoProyecto;
import com.MiPortfolio.SpringBoot.Security.Controller.Mensaje;
import com.MiPortfolio.SpringBoot.model.Proyecto;

import com.MiPortfolio.SpringBoot.service.ProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proy")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyServ;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
        if(!proyServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!proyServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyServ.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy){      
        if(StringUtils.isBlank(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyServ.existsByNombre(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoproy.getNombre(), dtoproy.getDescripcion());
        proyServ.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoProyecto dtoproy){
        //Validamos si existe el ID
        if(!proyServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(proyServ.existsByNombre(dtoproy.getNombre()) && proyServ.getByNombre(dtoproy.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = proyServ.getOne(id).get();
        proyecto.setNombre(dtoproy.getNombre());
        proyecto.setDescripcion((dtoproy.getDescripcion()));
        
        proyServ.save(proyecto);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }

}