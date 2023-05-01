package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.productoRepo;
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
public class productoTest {

    @Autowired
    private productoRepo productoRepo;

    @Test
    public void generarProducto(){
        producto producto = new producto(10, 10, 5000, 10000, "mora", "mora que enamora", "123", "123", new proveedor(), new categoria());
        productoRepo.save(producto);

        Assertions.assertEquals("mora", producto.getNombreProducto());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProducto(){
        producto buscado = productoRepo.findById(1).orElse(null);
        productoRepo.delete(buscado);

        Assertions.assertNull(productoRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProducto(){
        producto buscado = productoRepo.findById(3).orElse(null);
        Assertions.assertEquals("pulpa de mora", buscado.getNombreProducto());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarProductos(){
        List<producto> lista   = productoRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosBycantidad(){
        List<producto> productos = productoRepo.productosBycantidad(100);
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosDisponibles(){
        List<producto> productos = productoRepo.productosBydisponibes(60);
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosPrecio(){
        List<producto> productos = productoRepo.findproductosByPrecioVentaProducto(10000);
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosnombre(){
        producto producto = productoRepo.findByNombreProducto("pulpa de mora");
        System.out.println(producto.toString());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosFechaCosecha(){
        List<producto> productos = productoRepo.findByFechaCosecha("09/04/2023");
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosFechaMaduracion(){
        List<producto> productos = productoRepo.findByFechaMaduracion("15/04/2023");
        productos.forEach(System.out::println);
    }
}
