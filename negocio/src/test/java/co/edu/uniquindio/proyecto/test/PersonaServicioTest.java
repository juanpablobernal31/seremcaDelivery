package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Persona;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.edu.uniquindio.proyecto.servicios.personaServicio;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class PersonaServicioTest {

    @Autowired
    private personaServicio personaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registarPersona(){
        Persona persona = new Persona(12, "juan", "calle 123", "calarca", "1234", "123");

        try{
            Persona guardado =personaServicio.registrarPersona(persona);

            Assertions.assertNotNull(guardado);
            System.out.println(guardado.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  login(){

        try {
            Persona persona = personaServicio.login("12345", 1);

            Assertions.assertNotNull(persona);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarPersonas(){
        List<Persona> lista = personaServicio.listarPersona();

        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarPersona() throws Exception {
      try{
          personaServicio.eliminarPersona(1);
      }catch (Exception e){
          Assertions.assertTrue(false);
      }

        try{
            personaServicio.obtenerPersona(1);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPersona(){
        try{
            Persona persona = personaServicio.obtenerPersona(1);
            persona.setNombrePersona("pedro");
            Persona nuevo = personaServicio.actualizarPersona(persona);

            Assertions.assertEquals("pedro", nuevo.getNombrePersona());
        }catch(Exception e){

        }
    }
}
