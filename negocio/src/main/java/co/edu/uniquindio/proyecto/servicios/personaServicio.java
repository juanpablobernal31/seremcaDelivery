package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;

import java.util.List;

public interface personaServicio {

    Persona obtenerPersona(int id) throws Exception;
    Persona login(String contrasena, int id) throws Exception;
    Persona registrarPersona(Persona p) throws Exception;
    Persona actualizarPersona(Persona p) throws Exception;
    void eliminarPersona(int p) throws Exception;
    List<Persona> listarPersona();


}
