package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.repo.DepartamentoRepo;
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
    private DepartamentoRepo departamentoRepo;

    @Test
    public void crearDepartamento(){

        Departamento guardado = new Departamento("Quindio");
        Assertions.assertEquals("Quindio", guardado.getNombreDepartamento());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void elimindarDepartameno(){
        Departamento buscado = departamentoRepo.findById(1).orElse(null);

        departamentoRepo.delete(buscado);

        Optional <Departamento> eliminado = departamentoRepo.findById(1);
        Assertions.assertNull(departamentoRepo.findById(1).orElse(null));

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDepartamento(){
        Departamento buscado = departamentoRepo.findById(1).orElse(null);
        Assertions.assertEquals("Quindio", buscado.getNombreDepartamento());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarDepartametos(){
        List<Departamento> lista = departamentoRepo.findAll();
        //Imprimimos la lista
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productosFecahCosecha(){
        Departamento departamento = departamentoRepo.findByNombreDepartamento("Quindio");
        System.out.println(departamento.toString());
    }
}
