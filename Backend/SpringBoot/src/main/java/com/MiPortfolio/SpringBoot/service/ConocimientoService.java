
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Conocimiento;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.MiPortfolio.SpringBoot.repository.ConocimientoRepository;

@Service
@Transactional
public class ConocimientoService {
    @Autowired
    public ConocimientoRepository conoRepo;
    
    
    public List<Conocimiento> list(){
         return conoRepo.findAll();
     }

    
       public Optional<Conocimiento> getOne(Long id){
         return conoRepo.findById(id);
     }
     
     public Optional<Conocimiento> getByNombreC(String nombreC){
         return conoRepo.findByNombreC(nombreC);
     }
     
     public void save(Conocimiento cono){
         conoRepo.save(cono);
     }
     
     public void delete(Long id){
         conoRepo.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return conoRepo.existsById(id);
     }
     
     public boolean existsByNombreC(String nombreC){
         return conoRepo.existsByNombreC(nombreC);
     }
} 

