
package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.Dto.dtoHabilidad;
import com.MiPortfolio.SpringBoot.Security.Controller.Mensaje;
import com.MiPortfolio.SpringBoot.model.Habilidad;
import com.MiPortfolio.SpringBoot.service.HabilidadService;
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
@RequestMapping("hab")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {
    
    @Autowired
    public HabilidadService habiServ;


    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = habiServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") Long id){
        if(!habiServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = habiServ.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!habiServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        habiServ.delete(id);
        return new ResponseEntity(new Mensaje("habilidad eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidad dtohab){      
        if(StringUtils.isBlank(dtohab.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(habiServ.existsByNombre(dtohab.getNombre()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = new Habilidad(dtohab.getNombre(), dtohab.getTiempoDeExperiencia(),dtohab.getPorcentaje());
        habiServ.save(habilidad);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoHabilidad dtohab){
        //Validamos si existe el ID
        if(!habiServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(habiServ.existsByNombre(dtohab.getNombre()) && habiServ.getByNombre(dtohab.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohab.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = habiServ.getOne(id).get();
        habilidad.setNombre(dtohab.getNombre());
        habilidad.setTiempoDeExperiencia((dtohab.getTiempoDeExperiencia()));
        habilidad.setPorcentaje(dtohab.getPorcentaje());
        
        habiServ.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }

}

