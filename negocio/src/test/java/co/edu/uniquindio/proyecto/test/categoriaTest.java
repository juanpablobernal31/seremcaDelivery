package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repo.CategoriaRepo;
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
    private CategoriaRepo categoriaRepo;

    @Test
    public void crearCategoria(){
             Categoria categoria = new Categoria("mora rama", "canastilla de mora rama", 4, "kilo");
             Categoria guardado = categoriaRepo.save(categoria);

             Assertions.assertEquals("mora rama", guardado.getNombreCategoria());
    }

    @Test
    @Sql("classpath:dataset.sql")
    void eliminarCategoria(){
       Categoria buscado = categoriaRepo.findById(1).orElse(null);

        categoriaRepo.delete(buscado);
//Por último, verificamos que si haya quedado borrado
        Optional <Categoria> eliminado = categoriaRepo.findById(1);
        Assertions.assertNull(categoriaRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCategoria(){
        Categoria buscado = categoriaRepo.findById(1).orElse(null);
        Assertions.assertEquals("arreglada", buscado.getNombreCategoria());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCategoria(){
        List<Categoria> lista = categoriaRepo.findAll();
        //Imprimimos la lista
        lista.forEach(System.out::println);
    }

     @Test
    @Sql("classpath:dataset.sql")
    public void listarPorDiasMaduaracion(){
        List<Categoria> lista = categoriaRepo.listarDiasMaduracion(6);
        lista.forEach(System.out::println);
     }

     @Test
    @Sql("classpath:dataset.sql")
    public void nombreCategoria(){
        Categoria categoria = categoriaRepo.findByName("rama");
         System.out.println(categoria.toString());
        Assertions.assertEquals("rama", categoria.getNombreCategoria());
     }

}
