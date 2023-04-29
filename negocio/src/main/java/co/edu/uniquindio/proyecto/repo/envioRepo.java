package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades.envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface envioRepo extends JpaRepository<envio, Integer> {
}
