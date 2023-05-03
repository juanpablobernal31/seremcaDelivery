package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    public void generarProducto(){
        Producto producto = new Producto(10, 10, 5000, 10000, "mora", "mora que enamora", "123", "123", new Proveedor(), new Categoria());
        productoRepo.save(producto);

        Assertions.assertEquals("mora", producto.getNombreProducto());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProducto(){
        Producto buscado = productoRepo.findById(1).orElse(null);
        productoRepo.delete(buscado);

        Assertions.assertNull(productoRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProducto(){
        Producto buscado = productoRepo.findById(3).orElse(null);
        Assertions.assertEquals("pulpa de mora", buscado.getNombreProducto());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarProductos(){
        List<Producto> lista   = productoRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosBycantidad(){
        List<Producto> productos = productoRepo.productosBycantidad(100);
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosDisponibles(){
        List<Producto> productos = productoRepo.productosBydisponibes(60);
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosPrecio(){
        List<Producto> productos = productoRepo.findproductosByPrecioVentaProducto(10000);
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosnombre(){
        Producto producto = productoRepo.findByNombreProducto("pulpa de mora");
        System.out.println(producto.toString());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosFechaCosecha(){
        List<Producto> productos = productoRepo.findByFechaCosecha("09/04/2023");
        productos.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosFechaMaduracion(){
        List<Producto> productos = productoRepo.findByFechaMaduracion("15/04/2023");
        productos.forEach(System.out::println);
    }


}
