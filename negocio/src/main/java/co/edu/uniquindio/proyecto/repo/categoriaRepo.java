package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoriaRepo  extends JpaRepository <categoria, Integer> {

    @Query("select c from categoria c where c.diasMaduracion = ?1")
    categoria obtener(int diasMaduracion);

    @Query("select c from categoria c where c.diasMaduracion = :diasMaduaracion")
    List<categoria> listarDiasMaduracion(int diasMaduaracion);

    @Query("select  c from categoria c where c.nombreCategoria =:nombre")
    categoria countcategoriaBynombreCategoria(String nombre);
}
