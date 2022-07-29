
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Habilidad;
import com.MiPortfolio.SpringBoot.repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService {

    @Autowired
    public HabilidadRepository habiRepo;
    
    public List<Habilidad> list(){
         return habiRepo.findAll();
     }

    
       public Optional<Habilidad> getOne(Long id){
         return habiRepo.findById(id);
     }
     
     public Optional<Habilidad> getByNombre(String nombre){
         return habiRepo.findByNombre(nombre);
     }
     
     public void save(Habilidad hab){
         habiRepo.save(hab);
     }
     
     public void delete(Long id){
         habiRepo.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return habiRepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return habiRepo.existsByNombre(nombre);
     }
}

