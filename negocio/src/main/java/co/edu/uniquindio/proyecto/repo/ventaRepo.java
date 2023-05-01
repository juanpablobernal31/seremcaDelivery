package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ventaRepo extends JpaRepository<venta, Integer> {
}
