package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.puntoVentaRepo;
import co.edu.uniquindio.proyecto.repo.departamentoRepo;
import co.edu.uniquindio.proyecto.repo.municipioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class puntoVentaTest {

    @Autowired
    private puntoVentaRepo  puntoVentaRepo;

    @Autowired
    private departamentoRepo departamentoRepo;

    @Autowired
    private municipioRepo municipioRepo;
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

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVentaCapacidad(){
        List<puntoVenta> lista = puntoVentaRepo.findAllByCapacidad(5000);
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPuntoVentaByNombre(){
        puntoVenta buscado = puntoVentaRepo.findByNombrePuntoVenta("seremca");
        System.out.println(buscado.toString());
        Assertions.assertEquals("seremca", buscado.getNombrePuntoVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVentaDepartamento(){

        departamento departamento = departamentoRepo.findByNombreDepartamento("Quindio");
        List<puntoVenta> lista = puntoVentaRepo.findAllByIdDepartametoPV(departamento);
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVentaMunicipio(){

        municipio municipio = municipioRepo.findByNombremunicipio("Calarca");
        departamento departamento = departamentoRepo.findByNombreDepartamento("Quindio");
        List<puntoVenta> lista = puntoVentaRepo.findAllByIdDepartametoPVAndAndIdMunicipioPv(departamento, municipio);
        lista.forEach(System.out::println);
    }




}
