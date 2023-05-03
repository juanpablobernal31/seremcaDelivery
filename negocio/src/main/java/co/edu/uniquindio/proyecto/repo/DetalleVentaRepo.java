package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface DetalleVentaRepo extends JpaRepository <DetalleVenta, Integer> {
}
