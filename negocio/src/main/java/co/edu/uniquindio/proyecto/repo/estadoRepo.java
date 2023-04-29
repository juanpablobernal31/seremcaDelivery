package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface estadoRepo extends JpaRepository<estado, Integer> {
}
