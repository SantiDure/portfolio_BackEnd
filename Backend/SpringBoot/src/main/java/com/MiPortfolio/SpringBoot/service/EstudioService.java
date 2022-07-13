
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Estudio;
import com.MiPortfolio.SpringBoot.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService{

    @Autowired
    public EstudioRepository estuRepo;
    
    @Override
    public List<Estudio> verEstudios() {
        return estuRepo.findAll();
    }

    @Override
    public void crearEstudio(Estudio est) {
    estuRepo.save(est);
    }

    @Override
    public void borrarEstudio(Long id) {
    estuRepo.deleteById(id);
    }

    @Override
    public Estudio buscarEstudio(Long id) {
    return estuRepo.findById(id).orElse(null);
    }
    
}
