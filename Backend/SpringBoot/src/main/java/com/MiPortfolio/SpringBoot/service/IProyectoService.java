
package com.MiPortfolio.SpringBoot.service;

import com.MiPortfolio.SpringBoot.model.Proyecto;
import java.util.List;

public interface IProyectoService {
 
     public     List<Proyecto> verProyectos();
    
    public     void crearProyecto (Proyecto per);
    
    public     void borrarProyecto (Long id);
    
    public     Proyecto buscarProyecto (Long id);
}
