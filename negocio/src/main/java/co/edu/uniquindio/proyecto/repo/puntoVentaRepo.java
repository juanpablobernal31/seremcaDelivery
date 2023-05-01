package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.puntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface puntoVentaRepo extends JpaRepository<puntoVenta, Integer> {
}
