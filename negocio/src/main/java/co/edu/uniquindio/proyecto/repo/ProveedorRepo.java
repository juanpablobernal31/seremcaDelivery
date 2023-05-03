package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, Integer> {

    Proveedor findByCedulaNit(String cedula);

    Proveedor findByDepartamentoProveedor(Departamento departamento);

    @Query("select p from Proveedor p where p.departamentoProveedor = :departamento")
    List<Proveedor> findByDepartamentoProveedores(Departamento departamento);
}
