package co.edu.uniquindio.proyecto.test;



import co.edu.uniquindio.proyecto.entidades.Envio;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.PuntoVenta;
import co.edu.uniquindio.proyecto.repo.EnvioRepo;
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
public class EnvioTest {

    @Autowired
    private EnvioRepo envioRepo;


    @Test
    public void  generarEnvio(){

        Envio guardado = new Envio("calle 123", new PuntoVenta(), 1, new Persona(), new Estado(), "123", "123");

        Assertions.assertEquals("calle 123", guardado.getDireccionEnvio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarEnvio(){

        Envio buscado = envioRepo.findById(1).orElse(null);
        envioRepo.delete(buscado);

        Optional<Envio> borrado = envioRepo.findById(1);
        Assertions.assertNull(envioRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEnvio(){
        Envio buscado = envioRepo.findById(1).orElse(null);

        Assertions.assertEquals("calle 123#12-3", buscado.getDireccionEnvio());
    }

    @Test
    @Sql("classpath:dataset.sql")

    public void listarEnvios(){
        List<Envio> lista = envioRepo.findAll();

        lista.forEach(System.out::println);
    }
}
