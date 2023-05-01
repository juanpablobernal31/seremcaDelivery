package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.departamento;
import co.edu.uniquindio.proyecto.repo.departamentoRepo;
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
public class departamentoTest {

    @Autowired
    private departamentoRepo departamentoRepo;

    @Test
    public void crearDepartamento(){

        departamento guardado = new departamento("Quindio");
        Assertions.assertEquals("Quindio", guardado.getNombreDepartamento());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void elimindarDepartameno(){
        departamento buscado = departamentoRepo.findById(1).orElse(null);

        departamentoRepo.delete(buscado);

        Optional <departamento> eliminado = departamentoRepo.findById(1);
        Assertions.assertNull(departamentoRepo.findById(1).orElse(null));

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDepartamento(){
        departamento buscado = departamentoRepo.findById(1).orElse(null);
        Assertions.assertEquals("Quindio", buscado.getNombreDepartamento());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarDepartametos(){
        List<departamento> lista = departamentoRepo.findAll();
        //Imprimimos la lista
        lista.forEach(System.out::println);
    }
}
