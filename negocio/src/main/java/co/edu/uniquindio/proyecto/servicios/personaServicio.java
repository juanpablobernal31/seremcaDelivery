package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.persona;

import java.util.List;
import java.util.Optional;

public interface personaServicio {

    persona obtenerPersona(int id) throws Exception;
    persona  login( String contrasena, int id) throws Exception;
    persona registrarPersona(persona p) throws Exception;
    persona actualizarPersona(persona p) throws Exception;
    void eliminarPersona(int p) throws Exception;
    List<persona> listarPersona();


}
