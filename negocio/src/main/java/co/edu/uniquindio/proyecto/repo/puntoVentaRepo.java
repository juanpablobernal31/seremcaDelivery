package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.departamento;
import co.edu.uniquindio.proyecto.entidades.municipio;
import co.edu.uniquindio.proyecto.entidades.puntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface puntoVentaRepo extends JpaRepository<puntoVenta, Integer> {

    @Query("select pv from puntoVenta pv where pv.capacidadAlmacenamiento=:capacidad")
    List<puntoVenta> findAllByCapacidad(int capacidad);

    puntoVenta findByNombrePuntoVenta(String nombre);

    @Query("select pv from puntoVenta pv where pv.idDepartametoPV=:departamento")
    List<puntoVenta> findAllByIdDepartametoPV(departamento departamento);

    @Query("select pv from puntoVenta pv where pv.idDepartametoPV=:departamento and pv.idMunicipioPv =:municipio")
    List<puntoVenta> findAllByIdDepartametoPVAndAndIdMunicipioPv(departamento departamento, municipio municipio);
}
