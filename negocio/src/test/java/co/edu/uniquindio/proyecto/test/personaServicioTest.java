package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.persona;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.edu.uniquindio.proyecto.servicios.personaServicio;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class personaServicioTest {

    @Autowired
    private personaServicio personaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registarPersona(){
        persona persona = new persona(45, 0, "juan", "calle123", "calarca", "1234", "123");

        try{
            persona guardado =personaServicio.registrarPersona(persona);

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
            persona persona = personaServicio.login("12345", 1);

            Assertions.assertNotNull(persona);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarPersonas(){
        List<persona> lista = personaServicio.listarPersona();

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
            persona persona = personaServicio.obtenerPersona(1);
            persona.setNombrePersona("pedro");
            persona nuevo = personaServicio.actualizarPersona(persona);

            Assertions.assertEquals("pedro", nuevo.getNombrePersona());
        }catch(Exception e){

        }
    }
}
