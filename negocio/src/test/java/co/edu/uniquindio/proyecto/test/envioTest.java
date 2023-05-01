package co.edu.uniquindio.proyecto.test;



import co.edu.uniquindio.proyecto.entidades.envio;
import co.edu.uniquindio.proyecto.entidades.estado;
import co.edu.uniquindio.proyecto.entidades.persona;
import co.edu.uniquindio.proyecto.entidades.puntoVenta;
import co.edu.uniquindio.proyecto.repo.envioRepo;
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
public class envioTest {

    @Autowired
    private envioRepo envioRepo;


    @Test
    public void  generarEnvio(){

        envio guardado = new envio("calle 123", new puntoVenta(), 1, new persona(), new estado(), "123", "123");

        Assertions.assertEquals("calle 123", guardado.getDireccionEnvio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarEnvio(){

        envio buscado = envioRepo.findById(1).orElse(null);
        envioRepo.delete(buscado);

        Optional<envio> borrado = envioRepo.findById(1);
        Assertions.assertNull(envioRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEnvio(){
        envio buscado = envioRepo.findById(1).orElse(null);

        Assertions.assertEquals("calle 123#12-3", buscado.getDireccionEnvio());
    }

    @Test
    @Sql("classpath:dataset.sql")

    public void listarEnvios(){
        List<envio> lista = envioRepo.findAll();

        lista.forEach(System.out::println);
    }
}
