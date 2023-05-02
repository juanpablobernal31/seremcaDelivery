package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface personaRepo extends JpaRepository <persona, Integer>{
    @Query("select p from persona p where p.contrasena =:contraseña and p.idPersona =:idPersona")
    persona personaAutenticada (String contraseña, int idPersona);

    @Override
    Optional<persona> findById(Integer integer);
}
