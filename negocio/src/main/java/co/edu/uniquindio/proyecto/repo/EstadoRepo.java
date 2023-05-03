package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepo extends JpaRepository<Estado, Integer> {
}
