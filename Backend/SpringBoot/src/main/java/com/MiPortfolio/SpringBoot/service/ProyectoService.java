
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Proyecto;
import com.MiPortfolio.SpringBoot.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService  {

    @Autowired
    public ProyectoRepository proRepo;

   public List<Proyecto> list(){
         return proRepo.findAll();
     }

    
       public Optional<Proyecto> getOne(Long id){
         return proRepo.findById(id);
     }
     
     public Optional<Proyecto> getByNombre(String nombre){
         return proRepo.findByNombre(nombre);
     }
     
     public void save(Proyecto pro){
         proRepo.save(pro);
     }
     
     public void delete(Long id){
         proRepo.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return proRepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return proRepo.existsByNombre(nombre);
     }

}
