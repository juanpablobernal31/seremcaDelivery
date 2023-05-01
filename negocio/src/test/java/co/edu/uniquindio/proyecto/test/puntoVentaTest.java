package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.puntoVentaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class puntoVentaTest {

    @Autowired
    private puntoVentaRepo  puntoVentaRepo;

    @Test
    public void generarPuntoVenta(){
        puntoVenta guardado = new puntoVenta(new departamento(), 200, "don mora", new municipio());
        puntoVentaRepo.save(guardado);

        Assertions.assertEquals("don mora", guardado.getNombrePuntoVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPuntoVenta(){
        puntoVenta buscado = puntoVentaRepo.findById(1).orElse(null);
        puntoVentaRepo.delete(buscado);

        Assertions.assertNull(puntoVentaRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPuntoVenta(){
        puntoVenta buscado = puntoVentaRepo.findById(1).orElse(null);
        Assertions.assertEquals("donMora", buscado.getNombrePuntoVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVenta(){
        List<puntoVenta> lista = puntoVentaRepo.findAll();
        lista.forEach(System.out::println);
    }

}
