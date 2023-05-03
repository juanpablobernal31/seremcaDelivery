package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepo extends JpaRepository <Departamento, Integer> {
    Departamento findByNombreDepartamento(String nombre);
}
