package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.detalleVentaRepo;
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
public class detalleVentaTest {
    @Autowired
    private detalleVentaRepo detalleVentaRepo;


    @Test
    public void generarDetalleVenta(){
        persona persona = new persona(1, 1, "juan", "calle 123 #45-7", "calarca", "12345", "quindio");
        venta venta = new venta(persona, "12/04/2023", 60000);
        categoria categoria = new categoria("mora", "mora", 4, "kilo");
        proveedor proveedor = new proveedor();
        producto producto = new producto(100, 100, 6000, 10000, "mora", "mora", "12/04/2023", "20/04/2023", proveedor, categoria);

        detalleVenta guardado = new detalleVenta(venta, producto, 60000, 0, 1 );

        Assertions.assertEquals(60000, guardado.getPrecioTotal());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarDetalleVenta(){
        detalleVenta buscado = detalleVentaRepo.findById(1).orElse(null);

        detalleVentaRepo.delete(buscado);

        Optional <detalleVenta> eliminado = detalleVentaRepo.findById(1);
        Assertions.assertNull(detalleVentaRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDetalleVenta(){
        detalleVenta buscado = detalleVentaRepo.findById(1).orElse(null);

        Assertions.assertEquals(60000, buscado.getPrecioTotal());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarDetalleVenta(){
        List<detalleVenta> lista = detalleVentaRepo.findAll();
    lista.forEach(System.out::println);
    }
}
