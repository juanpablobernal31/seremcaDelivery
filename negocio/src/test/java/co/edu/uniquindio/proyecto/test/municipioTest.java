package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.municipioRepo;
import co.edu.uniquindio.proyecto.repo.departamentoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class municipioTest {

    @Autowired
    private municipioRepo municipioRepo;
    @Autowired
    private departamentoRepo departamentoRepo;
    @Test
    public void generarMunicipio(){

        municipio guardado = new municipio("calarca", new departamento());
        municipioRepo.save(guardado);

        Assertions.assertEquals("calarca", guardado.getNombremunicipio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMunicipio(){
        municipio buscado = municipioRepo.findById(1).orElse(null);

        municipioRepo.delete(buscado);

        Assertions.assertNull(municipioRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMunicipio(){
        municipio buscado = municipioRepo.findById(1).orElse(null);

        Assertions.assertEquals("Calarca", buscado.getNombremunicipio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarMunicipio(){
        List<municipio> lista = municipioRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMunicipioNombre(){
        municipio municipio = municipioRepo.findByNombremunicipio("Calarca");
        System.out.println(municipio.toString());

        Assertions.assertEquals("Calarca", municipio.getNombremunicipio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public  void listarMunicipioDepartamento(){
        departamento departamento = departamentoRepo.findByNombreDepartamento("Huila");
        List<municipio> lista = municipioRepo.findByDepartamento(departamento);
        lista.forEach(System.out::println);
    }
}
