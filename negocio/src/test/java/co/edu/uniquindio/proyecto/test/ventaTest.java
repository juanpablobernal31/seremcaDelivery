package co.edu.uniquindio.proyecto.test;



import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.ventaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ventaTest {

    @Autowired
    private ventaRepo ventaRepo;

    @Test
    public void generarVenta(){
        venta guardado = new venta(new persona(), "123", 12345);
        ventaRepo.save(guardado);

        Assertions.assertEquals(12345, guardado.getPrecioVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarVenta(){
        venta buscado = ventaRepo.findById(1).orElse(null);
        ventaRepo.delete(buscado);

        Assertions.assertNull(ventaRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVenta(){
        venta buscado = ventaRepo.findById(1).orElse(null);
        Assertions.assertEquals(60000, buscado.getPrecioVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarVentas(){
        List<venta> lista = ventaRepo.findAll();
        lista.forEach(System.out::println);
    }
}
