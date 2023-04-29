package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaRepo  extends JpaRepository <categoria, Integer> {
}
