package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.departamento;
import co.edu.uniquindio.proyecto.entidades.proveedor;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface proveedorRepo extends JpaRepository<proveedor, Integer> {

    proveedor findByCedulaNit(String cedula);

    proveedor findByDepartamentoProveedor(departamento departamento);

    @Query("select p from proveedor p where p.departamentoProveedor = :departamento")
    List<proveedor> findByDepartamentoProveedores(departamento departamento);
}
