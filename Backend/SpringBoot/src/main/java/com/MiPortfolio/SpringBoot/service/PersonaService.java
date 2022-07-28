
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Persona;
import com.MiPortfolio.SpringBoot.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {

    @Autowired
    public PersonaRepository persoRepo;
    
    public List<Persona> list(){
         return persoRepo.findAll();
     }

    
       public Optional<Persona> getOne(Long id){
         return persoRepo.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return persoRepo.findByNombre(nombre);
     }
     
     public void save(Persona per){
         persoRepo.save(per);
     }
     
     public void delete(Long id){
         persoRepo.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return persoRepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return persoRepo.existsByNombre(nombre);
     }
}
