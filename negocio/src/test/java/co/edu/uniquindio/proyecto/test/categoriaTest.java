package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.categoria;
import co.edu.uniquindio.proyecto.repo.categoriaRepo;
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
public class categoriaTest {
    @Autowired
    private categoriaRepo categoriaRepo;

    @Test
    public void crearCategoria(){
             categoria categoria = new categoria("mora rama", "canastilla de mora rama", 4, "kilo");
             categoria guardado = categoriaRepo.save(categoria);

             Assertions.assertEquals("mora rama", guardado.getNombreCategoria());
    }

    @Test
    @Sql("classpath:dataset.sql")
    void eliminarCategoria(){
       categoria buscado = categoriaRepo.findById(1).orElse(null);

        categoriaRepo.delete(buscado);
//Por último, verificamos que si haya quedado borrado
        Optional <categoria> eliminado = categoriaRepo.findById(1);
        Assertions.assertNull(categoriaRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCategoria(){
        categoria buscado = categoriaRepo.findById(1).orElse(null);
        Assertions.assertEquals("arreglada", buscado.getNombreCategoria());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCategoria(){
        List<categoria> lista = categoriaRepo.findAll();
        //Imprimimos la lista
        lista.forEach(System.out::println);
    }

}
