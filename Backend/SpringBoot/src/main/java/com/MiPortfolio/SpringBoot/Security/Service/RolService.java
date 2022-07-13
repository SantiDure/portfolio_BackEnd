
package com.MiPortfolio.SpringBoot.Security.Service;

import com.MiPortfolio.SpringBoot.Security.Entity.Rol;
import com.MiPortfolio.SpringBoot.Security.Enums.RolNombre;
import com.MiPortfolio.SpringBoot.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
    irolRepository.save(rol);
    }
}
