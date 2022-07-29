
package com.MiPortfolio.SpringBoot.repository;

import com.MiPortfolio.SpringBoot.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
