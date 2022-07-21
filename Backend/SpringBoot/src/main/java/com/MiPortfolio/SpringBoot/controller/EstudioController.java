package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.Dto.dtoEstudio;
import com.MiPortfolio.SpringBoot.Security.Controller.Mensaje;
import com.MiPortfolio.SpringBoot.model.Estudio;

import com.MiPortfolio.SpringBoot.service.EstudioService;
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
@RequestMapping("est")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudioController {
    
    @Autowired
    public EstudioService estuServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = estuServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") Long id){
        if(!estuServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudio estudio = estuServ.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!estuServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        estuServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudio dtoest){      
        if(StringUtils.isBlank(dtoest.getNombreEst()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(estuServ.existsByNombreEst(dtoest.getNombreEst()))
            return new ResponseEntity(new Mensaje("Ese estudio existe"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = new Estudio(dtoest.getNombreEst(), dtoest.getEspecializacion());
        estuServ.save(estudio);
        
        return new ResponseEntity(new Mensaje("Estudio agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoEstudio dtoest){
        //Validamos si existe el ID
        if(!estuServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(estuServ.existsByNombreEst(dtoest.getNombreEst()) && estuServ.getByNombreEst(dtoest.getNombreEst()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese estudio ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoest.getNombreEst()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = estuServ.getOne(id).get();
        estudio.setNombreEst(dtoest.getNombreEst());
        estudio.setEspecializacion((dtoest.getEspecializacion()));
        
        estuServ.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
             
    }

}

