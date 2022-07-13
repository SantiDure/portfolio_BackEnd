
package com.MiPortfolio.SpringBoot.repository;

import com.MiPortfolio.SpringBoot.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
    
}
