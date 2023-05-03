package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepo extends JpaRepository<Venta, Integer> {
}
