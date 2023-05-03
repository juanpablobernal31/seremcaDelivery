package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepo extends JpaRepository <Categoria, Integer> {

    @Query("select c from Categoria c where c.diasMaduracion = ?1")
    Categoria obtener(int diasMaduracion);

    @Query("select c from Categoria c where c.diasMaduracion = :diasMaduaracion")
    List<Categoria> listarDiasMaduracion(int diasMaduaracion);

    @Query("select  c from Categoria c where c.nombreCategoria =:nombre")
    Categoria countcategoriaBynombreCategoria(String nombre);
}
