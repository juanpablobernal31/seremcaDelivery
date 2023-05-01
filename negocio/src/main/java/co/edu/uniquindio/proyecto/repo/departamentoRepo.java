package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departamentoRepo extends JpaRepository <departamento, Integer> {
}
