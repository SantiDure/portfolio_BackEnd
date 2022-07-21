
package com.MiPortfolio.SpringBoot.repository;

import com.MiPortfolio.SpringBoot.model.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudioRepository extends JpaRepository<Estudio, Long>{
    public Optional<Estudio> findByNombreEst(String nombreEst);
    public boolean existsByNombreEst(String nombreEst);
}
