package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.ProveedorRepo;
import co.edu.uniquindio.proyecto.repo.DepartamentoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProveedorTest {

    @Autowired
    private ProveedorRepo proveedorRepo;

    @Autowired
    DepartamentoRepo departamentoRepo;

    @Test
    public void generarProveedor(){
        Proveedor guardado = new Proveedor(10, 10, 1, EsAsociacion.SI, 123, "mora mor", "123", new Municipio(), new Departamento());
        proveedorRepo.save(guardado);

        Assertions.assertEquals("mora mor", guardado.getNombreProveedor());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void   eliminarProveedor(){
        Proveedor buscado = proveedorRepo.findById(1).orElse(null);
        proveedorRepo.delete(buscado);

        Assertions.assertNull(proveedorRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProveedor(){
        Proveedor buscado = proveedorRepo.findById(1).orElse(null);
        Assertions.assertEquals("asoMoras", buscado.getNombreProveedor());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProveedores(){
        List<Proveedor> lista = proveedorRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void departamentoProveedor(){
        Departamento departamento;
        departamento = departamentoRepo.findById(1).orElse(null);
        Proveedor proveedores = proveedorRepo.findByDepartamentoProveedor(departamento);

        System.out.println(proveedores.toString());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void    listarDepartamentoProveedor(){
        Departamento departamento;
        departamento = departamentoRepo.findById(4).orElse(null);

        List<Proveedor> Proveedors = proveedorRepo.findByDepartamentoProveedores(departamento);

        Proveedors.forEach(System.out::println);
    }
}
