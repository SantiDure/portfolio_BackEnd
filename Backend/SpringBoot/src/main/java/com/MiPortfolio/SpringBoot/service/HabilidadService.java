
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Habilidad;
import com.MiPortfolio.SpringBoot.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService{

    @Autowired
    public HabilidadRepository habiRepo;
    
    @Override
    public List<Habilidad> verHabilidades() {
        return habiRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad habi) {
        habiRepo.save(habi);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habiRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habiRepo.findById(id).orElse(null);
    }
    
   
}
