
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public     List<Experiencia> verExperiencias();
    
    public     void crearExperiencia (Experiencia habi);
    
    public     void borrarExperiencia (Long id);
    
    public     Experiencia buscarExperiencia (Long id);
}

