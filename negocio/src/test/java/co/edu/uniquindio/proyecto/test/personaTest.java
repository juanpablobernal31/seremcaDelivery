package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.persona;
import co.edu.uniquindio.proyecto.repo.personaRepo;
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
public class personaTest {

    @Autowired
    private personaRepo personaRepo;

    @Test
    public void registrarPersona(){
        persona persona = new persona(1234, 1, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        persona guardado = personaRepo.save(persona);


        Assertions.assertEquals("juan", guardado.getNombrePersona());
    }

    @Test
    @Sql("classpath:dataset.sql")
    void eliminarPersona(){
        persona buscado = personaRepo.findById(4).orElse(null);


        personaRepo.delete(buscado);
//Por último, verificamos que si haya quedado borrado
        Optional <persona> eliminado = personaRepo.findById(4);
        Assertions.assertNull(personaRepo.findById(4).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void actualizarPersona(){

//Por último, verificamos que si haya quedado actualizado
        persona buscado = personaRepo.findById(3).orElse(null);
        Assertions.assertEquals("pablo", buscado.getNombrePersona());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPersona(){
        persona buscado = personaRepo.findById(1).orElse(null);
        Assertions.assertEquals("juan", buscado.getNombrePersona());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        //Obtenemos la lista de todos los usuarios
        List<persona> lista = personaRepo.findAll();
        //Imprimimos la lista
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void autenticacion(){
        persona persona = personaRepo.personaAutenticada("12345", 1);
        System.out.println(persona.toString());

        Assertions.assertNotNull(persona);
    }
}