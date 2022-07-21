
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Estudio;
import com.MiPortfolio.SpringBoot.repository.EstudioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EstudioService{

    @Autowired
    public EstudioRepository estuRepo;
    
    public List<Estudio> list(){
         return estuRepo.findAll();
     }

    
       public Optional<Estudio> getOne(Long id){
         return estuRepo.findById(id);
     }
     
     public Optional<Estudio> getByNombreEst(String nombreEst){
         return estuRepo.findByNombreEst(nombreEst);
     }
     
     public void save(Estudio estu){
         estuRepo.save(estu);
     }
     
     public void delete(Long id){
         estuRepo.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return estuRepo.existsById(id);
     }
     
     public boolean existsByNombreEst(String nombreEst){
         return estuRepo.existsByNombreEst(nombreEst);
     }
}