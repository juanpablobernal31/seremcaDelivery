package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface proveedorRepo extends JpaRepository<proveedor, Integer> {
}
