
package com.MiPortfolio.SpringBoot.controller;

import com.MiPortfolio.SpringBoot.Dto.dtoConocimiento;
import org.apache.commons.lang3.StringUtils;
import com.MiPortfolio.SpringBoot.Security.Controller.Mensaje;
import com.MiPortfolio.SpringBoot.model.Conocimiento;
import com.MiPortfolio.SpringBoot.service.ConocimientoService;
import java.util.List;
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
@RequestMapping("cono")
@CrossOrigin(origins = "http://localhost:4200")
public class ConocimientoController {
    @Autowired
    public ConocimientoService conoServ;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Conocimiento>> list(){
        List<Conocimiento> list = conoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Conocimiento> getById(@PathVariable("id") Long id){
        if(!conoServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Conocimiento conocimiento = conoServ.getOne(id).get();
        return new ResponseEntity(conocimiento, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!conoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        conoServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoConocimiento dtocono){      
        if(StringUtils.isBlank(dtocono.getNombreC()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(conoServ.existsByNombreC(dtocono.getNombreC()))
            return new ResponseEntity(new Mensaje("Ese concimiento existe"), HttpStatus.BAD_REQUEST);
        
        Conocimiento conocimiento = new Conocimiento (dtocono.getNombreC());
        conoServ.save(conocimiento);
        
        return new ResponseEntity(new Mensaje("Conocimiento agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoConocimiento dtocono){
        //Validamos si existe el ID
        if(!conoServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(conoServ.existsByNombreC(dtocono.getNombreC()) && conoServ.getByNombreC(dtocono.getNombreC()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese conocimiento ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtocono.getNombreC()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Conocimiento conocimiento = conoServ.getOne(id).get();
        conocimiento.setNombreC(dtocono.getNombreC());
        
        
        conoServ.save(conocimiento);
        return new ResponseEntity(new Mensaje("Conocimiento actualizado"), HttpStatus.OK);
             
    }

}
