
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Experiencia;
import com.MiPortfolio.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExperienciaService {

    @Autowired
    public ExperienciaRepository expeRepo;
    
    
    public List<Experiencia> list(){
         return expeRepo.findAll();
     }

    
       public Optional<Experiencia> getOne(Long id){
         return expeRepo.findById(id);
     }
     
     public Optional<Experiencia> getByNombreE(String nombreE){
         return expeRepo.findByNombreE(nombreE);
     }
     
     public void save(Experiencia expe){
         expeRepo.save(expe);
     }
     
     public void delete(Long id){
         expeRepo.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return expeRepo.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return expeRepo.existsByNombreE(nombreE);
     }
}