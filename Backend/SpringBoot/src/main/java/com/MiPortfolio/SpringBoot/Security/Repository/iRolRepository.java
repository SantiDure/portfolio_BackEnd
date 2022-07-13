
package com.MiPortfolio.SpringBoot.Security.Repository;

import com.MiPortfolio.SpringBoot.Security.Entity.Rol;
import com.MiPortfolio.SpringBoot.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
