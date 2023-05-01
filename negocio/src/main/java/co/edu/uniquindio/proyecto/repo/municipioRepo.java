package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades.departamento;
import co.edu.uniquindio.proyecto.entidades.municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface municipioRepo extends JpaRepository<municipio, Integer> {

    municipio findByNombremunicipio(String nombre);

    @Query("select m from municipio m where m.idDepartMunicipio=:departamento")
    List<municipio> findByDepartamento(departamento departamento);
}
