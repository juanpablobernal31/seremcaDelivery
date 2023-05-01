package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades.detalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface detalleVentaRepo extends JpaRepository <detalleVenta, Integer> {
}
