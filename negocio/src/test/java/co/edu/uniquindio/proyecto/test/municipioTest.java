package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.municipioRepo;
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

public class municipioTest {

    @Autowired
    private municipioRepo municipioRepo;

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
}
