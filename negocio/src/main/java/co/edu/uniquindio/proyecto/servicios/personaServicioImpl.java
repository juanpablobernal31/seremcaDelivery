package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repo.PersonaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class personaServicioImpl implements personaServicio {

    private PersonaRepo personaRepo;

    public personaServicioImpl(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    @Override
    public Persona obtenerPersona(int id) throws Exception {
        Persona persona =personaRepo.findById(id).orElse(null);

        if (persona ==null){
            throw  new Exception("datos incorrectos");
        }
        return persona;
    }

    @Override
    public Persona login(String contrasena, int id) throws Exception {
        Persona persona =personaRepo.personaAutenticada(contrasena, id);

        if (persona ==null){
            throw  new Exception("datos incorrectos");
        }
            return persona;
    }

    @Override
    public Persona registrarPersona(Persona p) throws Exception{
        boolean bandera = findById(p.getIdPersona());
        if(bandera){
            throw new Exception("identificacion de usuario ya existe.");
        }
        return personaRepo.save(p);
    }

    private boolean findById(int id){
        return personaRepo.findById(id).orElse(null) != null;
    }

    @Override
    public Persona actualizarPersona(Persona p) throws Exception{
        Optional<Persona> buscado = personaRepo.findById(p.getIdPersona());
        if(buscado.isEmpty()){
            throw new Exception("cliente no existente");
        }
        return personaRepo.save(p);
    }

    @Override
    public void eliminarPersona(int p) throws Exception{
        Optional<Persona> buscado = personaRepo.findById(p);
        if(buscado.isEmpty()){
            throw new Exception("cliente no existente");
        }

        personaRepo.delete(buscado.get());
    }

    @Override
    public List<Persona> listarPersona() {
        return personaRepo.findAll();
    }
}
