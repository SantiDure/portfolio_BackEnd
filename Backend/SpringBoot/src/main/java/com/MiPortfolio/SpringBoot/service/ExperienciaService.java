
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Experiencia;
import com.MiPortfolio.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    public ExperienciaRepository expeRepo;
    
    @Override
    public List<Experiencia> verExperiencias() {
    return expeRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia habi) {
    expeRepo.save(habi);
    }

    @Override
    public void borrarExperiencia(Long id) {
    expeRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
    return expeRepo.findById(id).orElse(null);
    }
    
}
