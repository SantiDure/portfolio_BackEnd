
package com.MiPortfolio.SpringBoot.controller;



import com.MiPortfolio.SpringBoot.Dto.dtoPersona;
import com.MiPortfolio.SpringBoot.Security.Controller.Mensaje;
import com.MiPortfolio.SpringBoot.model.Persona;
import com.MiPortfolio.SpringBoot.service.PersonaService;
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
@RequestMapping("per")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private PersonaService persoServ;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = persoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!persoServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = persoServ.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!persoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        persoServ.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoper){      
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(persoServ.existsByNombre(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtoper.getNombre(), dtoper.getApellido(),dtoper.getEmail(), dtoper.getPresentacion(), dtoper.getTelefono(), dtoper.getUrlFoto());
        persoServ.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoPersona dtoper){
        //Validamos si existe el ID
        if(!persoServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(persoServ.existsByNombre(dtoper.getNombre()) && persoServ.getByNombre(dtoper.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = persoServ.getOne(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setApellido((dtoper.getApellido()));
        persona.setEmail(dtoper.getEmail());
        persona.setPresentacion(dtoper.getPresentacion());
        persona.setTelefono(dtoper.getTelefono());
        persona.setUrlFoto(dtoper.getUrlFoto());
        
        persoServ.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }

}