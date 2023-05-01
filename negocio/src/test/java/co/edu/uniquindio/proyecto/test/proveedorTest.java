package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.proveedorRepo;
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

public class proveedorTest {

    @Autowired
    private proveedorRepo proveedorRepo;


    @Test
    public void generarProveedor(){
        proveedor guardado = new proveedor(10, 10, 1, esAsociacion.SI, 123, "mora mor", "123", new municipio(), new departamento());
        proveedorRepo.save(guardado);

        Assertions.assertEquals("mora mor", guardado.getNombreProveedor());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void   eliminarProveedor(){
        proveedor buscado = proveedorRepo.findById(1).orElse(null);
        proveedorRepo.delete(buscado);

        Assertions.assertNull(proveedorRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProveedor(){
        proveedor buscado = proveedorRepo.findById(1).orElse(null);
        Assertions.assertEquals("asoMoras", buscado.getNombreProveedor());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProveedores(){
        List<proveedor> lista = proveedorRepo.findAll();
        lista.forEach(System.out::println);
    }
}
