package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.entidades.Municipio;
import co.edu.uniquindio.proyecto.entidades.PuntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntoVentaRepo extends JpaRepository<PuntoVenta, Integer> {

    @Query("select pv from PuntoVenta pv where pv.capacidadAlmacenamiento=:capacidad")
    List<PuntoVenta> findAllByCapacidad(int capacidad);

    PuntoVenta findByNombrePuntoVenta(String nombre);

    @Query("select pv from PuntoVenta pv where pv.idDepartametoPV=:departamento")
    List<PuntoVenta> findAllByIdDepartametoPV(Departamento departamento);

    @Query("select pv from PuntoVenta pv where pv.idDepartametoPV=:departamento and pv.idMunicipioPv =:municipio")
    List<PuntoVenta> findAllByIdDepartametoPVAndAndIdMunicipioPv(Departamento departamento, Municipio municipio);
}
