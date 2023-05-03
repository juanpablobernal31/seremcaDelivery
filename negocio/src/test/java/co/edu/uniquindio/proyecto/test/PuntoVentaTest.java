package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.PuntoVentaRepo;
import co.edu.uniquindio.proyecto.repo.DepartamentoRepo;
import co.edu.uniquindio.proyecto.repo.MunicipioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PuntoVentaTest {

    @Autowired
    private PuntoVentaRepo puntoVentaRepo;

    @Autowired
    private DepartamentoRepo departamentoRepo;

    @Autowired
    private MunicipioRepo municipioRepo;
    @Test
    public void generarPuntoVenta(){
        PuntoVenta guardado = new PuntoVenta(new Departamento(), 200, "don mora", new Municipio());
        puntoVentaRepo.save(guardado);

        Assertions.assertEquals("don mora", guardado.getNombrePuntoVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPuntoVenta(){
        PuntoVenta buscado = puntoVentaRepo.findById(1).orElse(null);
        puntoVentaRepo.delete(buscado);

        Assertions.assertNull(puntoVentaRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPuntoVenta(){
        PuntoVenta buscado = puntoVentaRepo.findById(1).orElse(null);
        Assertions.assertEquals("donMora", buscado.getNombrePuntoVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVenta(){
        List<PuntoVenta> lista = puntoVentaRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVentaCapacidad(){
        List<PuntoVenta> lista = puntoVentaRepo.findAllByCapacidad(5000);
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPuntoVentaByNombre(){
        PuntoVenta buscado = puntoVentaRepo.findByNombrePuntoVenta("seremca");
        System.out.println(buscado.toString());
        Assertions.assertEquals("seremca", buscado.getNombrePuntoVenta());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVentaDepartamento(){

        Departamento departamento = departamentoRepo.findByNombreDepartamento("Quindio");
        List<PuntoVenta> lista = puntoVentaRepo.findAllByIdDepartametoPV(departamento);
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPuntosVentaMunicipio(){

        Municipio municipio = municipioRepo.findByNombremunicipio("Calarca");
        Departamento departamento = departamentoRepo.findByNombreDepartamento("Quindio");
        List<PuntoVenta> lista = puntoVentaRepo.findAllByIdDepartametoPVAndAndIdMunicipioPv(departamento, municipio);
        lista.forEach(System.out::println);
    }




}
