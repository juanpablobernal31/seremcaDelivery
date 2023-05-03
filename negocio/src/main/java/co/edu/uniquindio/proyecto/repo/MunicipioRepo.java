package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepo extends JpaRepository<Municipio, Integer> {

    Municipio findByNombremunicipio(String nombre);

    @Query("select m from Municipio m where m.idDepartMunicipio=:departamento")
    List<Municipio> findByDepartamento(Departamento departamento);
}
