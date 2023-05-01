package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personaRepo extends JpaRepository <persona, Integer>{


}
