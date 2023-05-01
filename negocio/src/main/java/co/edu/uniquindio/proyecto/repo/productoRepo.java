package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepo extends JpaRepository<producto, Integer> {
}
