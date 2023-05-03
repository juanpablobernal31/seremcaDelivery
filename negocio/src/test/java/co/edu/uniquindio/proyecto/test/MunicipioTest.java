package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.MunicipioRepo;
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

public class MunicipioTest {

    @Autowired
    private MunicipioRepo municipioRepo;
    @Autowired
    private DepartamentoRepo departamentoRepo;
    @Test
    public void generarMunicipio(){

        Municipio guardado = new Municipio("calarca", new Departamento());
        municipioRepo.save(guardado);

        Assertions.assertEquals("calarca", guardado.getNombremunicipio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMunicipio(){
        Municipio buscado = municipioRepo.findById(1).orElse(null);

        municipioRepo.delete(buscado);

        Assertions.assertNull(municipioRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMunicipio(){
        Municipio buscado = municipioRepo.findById(1).orElse(null);

        Assertions.assertEquals("Calarca", buscado.getNombremunicipio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarMunicipio(){
        List<Municipio> lista = municipioRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMunicipioNombre(){
        Municipio municipio = municipioRepo.findByNombremunicipio("Calarca");
        System.out.println(municipio.toString());

        Assertions.assertEquals("Calarca", municipio.getNombremunicipio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarMunicipioDepartamento(){
        Departamento departamento = departamentoRepo.findByNombreDepartamento("Huila");
        List<Municipio> lista = municipioRepo.findByDepartamento(departamento);
        lista.forEach(System.out::println);
    }
}
