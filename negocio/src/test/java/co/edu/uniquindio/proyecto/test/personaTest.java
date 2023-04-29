package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.persona;
import co.edu.uniquindio.proyecto.entidades.rol;
import co.edu.uniquindio.proyecto.repo.personaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class personaTest {

    @Autowired
    private personaRepo personaRepo;

    @Test
    public void registrarPersona(){
        rol rolPersona = new rol("admin");
        persona persona = new persona(1234, rolPersona, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        persona guardado = personaRepo.save(persona);


        Assertions.assertEquals("juan", guardado.getNombrePersona());
    }

    @Test
    void eliminarPersona(){
        rol rolPersona = new rol("admin");
        persona persona = new persona(1234, rolPersona, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        persona guardado = personaRepo.save(persona);

        personaRepo.delete(guardado);
//Por último, verificamos que si haya quedado borrado
        Optional <persona> buscado = personaRepo.findById(1234);
        Assertions.assertNull(buscado.orElse(null));

    }

    @Test
    public  void actualizarPersona(){
        rol rolPersona = new rol("admin");
        persona persona = new persona(1234, rolPersona, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        persona guardado = personaRepo.save(persona);

        guardado.setNombrePersona("pedro");
//Con save guardamos el registro modificado
        personaRepo.save(guardado);
//Por último, verificamos que si haya quedado actualizado
        persona buscado = personaRepo.findById(1234).orElse(null);
        Assertions.assertEquals("pedro", buscado.getNombrePersona());
    }

    @Test
    public void obtenerPersona(){
        rol rolPersona = new rol("admin");
        persona persona = new persona(1234, rolPersona, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        persona guardado = personaRepo.save(persona);

        System.out.println(guardado.toString());

        Assertions.assertEquals("juan", guardado.getNombrePersona());
    }

    @Test
    public void listar(){

        //Obtenemos la lista de todos los usuarios
        List<persona> lista = personaRepo.findAll();
        //Imprimimos la lista
        System.out.println(lista);
    }
}