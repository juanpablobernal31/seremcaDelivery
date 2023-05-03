package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repo.PersonaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonaTest {

    @Autowired
    private PersonaRepo personaRepo;

    @Test
    public void registrarPersona(){
        Persona persona = new Persona(1234, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        Persona guardado = personaRepo.save(persona);


        Assertions.assertEquals("juan", guardado.getNombrePersona());
    }

    @Test
    @Sql("classpath:dataset.sql")
    void eliminarPersona(){
        Persona buscado = personaRepo.findById(4).orElse(null);


        personaRepo.delete(buscado);
//Por último, verificamos que si haya quedado borrado
        Optional <Persona> eliminado = personaRepo.findById(4);
        Assertions.assertNull(personaRepo.findById(4).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void actualizarPersona(){

//Por último, verificamos que si haya quedado actualizado
        Persona buscado = personaRepo.findById(3).orElse(null);
        Assertions.assertEquals("pablo", buscado.getNombrePersona());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPersona(){
        Persona buscado = personaRepo.findById(1).orElse(null);
        Assertions.assertEquals("juan", buscado.getNombrePersona());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        //Obtenemos la lista de todos los usuarios
        List<Persona> lista = personaRepo.findAll();
        //Imprimimos la lista
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void autenticacion(){
        Persona persona = personaRepo.personaAutenticada("12345", 1);
        System.out.println(persona.toString());

        Assertions.assertNotNull(persona);
    }
}