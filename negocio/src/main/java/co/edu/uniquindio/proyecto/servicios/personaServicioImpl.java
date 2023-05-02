package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.persona;
import co.edu.uniquindio.proyecto.repo.personaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class personaServicioImpl implements personaServicio {

    private  personaRepo personaRepo;

    public personaServicioImpl(co.edu.uniquindio.proyecto.repo.personaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    @Override
    public persona obtenerPersona(int id) throws Exception {
        persona persona =personaRepo.findById(id).orElse(null);

        if (persona ==null){
            throw  new Exception("datos incorrectos");
        }
        return persona;
    }

    @Override
    public persona login( String contrasena, int id) throws Exception {
        persona persona =personaRepo.personaAutenticada(contrasena, id);

        if (persona ==null){
            throw  new Exception("datos incorrectos");
        }
            return persona;
    }

    @Override
    public persona registrarPersona(persona p) throws Exception{
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
    public persona actualizarPersona(persona p) throws Exception{
        Optional<persona> buscado = personaRepo.findById(p.getIdPersona());
        if(buscado.isEmpty()){
            throw new Exception("cliente no existente");
        }
        return personaRepo.save(p);
    }

    @Override
    public void eliminarPersona(int p) throws Exception{
        Optional<persona> buscado = personaRepo.findById(p);
        if(buscado.isEmpty()){
            throw new Exception("cliente no existente");
        }

        personaRepo.delete(buscado.get());
    }

    @Override
    public List<persona> listarPersona() {
        return personaRepo.findAll();
    }
}
