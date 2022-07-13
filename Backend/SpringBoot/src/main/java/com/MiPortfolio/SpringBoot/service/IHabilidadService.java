package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Habilidad;
import java.util.List;


public interface IHabilidadService {
    
    public     List<Habilidad> verHabilidades();
    
    public     void crearHabilidad (Habilidad habi);
    
    public     void borrarHabilidad (Long id);
    
    public     Habilidad buscarHabilidad (Long id);
}
