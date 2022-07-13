
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Estudio;
import java.util.List;


public interface IEstudioService {
    public     List<Estudio> verEstudios();
    
    public     void crearEstudio (Estudio est);
    
    public     void borrarEstudio (Long id);
    
    public     Estudio buscarEstudio (Long id);
    
}
