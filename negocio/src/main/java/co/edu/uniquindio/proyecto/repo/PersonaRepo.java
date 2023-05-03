package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository <Persona, Integer>{
    @Query("select p from Persona p where p.contrasena =:contraseña and p.idPersona =:idPersona")
    Persona personaAutenticada (String contraseña, int idPersona);

    @Override
    Optional<Persona> findById(Integer integer);
}
