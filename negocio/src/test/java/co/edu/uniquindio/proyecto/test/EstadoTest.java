package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.EstadoRepo;
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

public class EstadoTest {

    @Autowired
    private EstadoRepo estadoRepo;

    @Test
    public void generarestado(){
        Estado guardado = new Estado("enviado", "se envio el pedido.");
        estadoRepo.save(guardado);

        Assertions.assertEquals("enviado", guardado.getNombreEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarEstado(){
        Estado buscado = estadoRepo.findById(1).orElse(null);
        estadoRepo.delete(buscado);

        Optional<Estado> borrado = estadoRepo.findById(1);
        Assertions.assertNull(estadoRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEstado(){
        Estado buscado = estadoRepo.findById(1).orElse(null);
        Assertions.assertEquals("Recibido", buscado.getNombreEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarEstado(){
        List<Estado> lista = estadoRepo.findAll();
        lista.forEach(System.out::println);
    }
}
