package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.DTO.productoDTO;
import co.edu.uniquindio.proyecto.entidades.producto;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productoRepo extends JpaRepository<producto, Integer> {

    @Query("select p from producto p where p.cantidadProducto=:cantidad")
    List<producto> productosBycantidad(int cantidad);

    @Query("select p from producto p where p.disponible=:cantidad")
    List<producto> productosBydisponibes(int cantidad);

    @Query("select p from producto p where p.precioVentaProducto=:precio")
    List<producto> findproductosByPrecioVentaProducto(float precio);

    producto findByNombreProducto(String nombre);

    @Query("select  p from producto p where p.fechaCosecha=:fecha")
    List<producto> findByFechaCosecha(String fecha);

    @Query("select  p from producto p where p.fechaMaduracion=:fecha")
    List<producto> findByFechaMaduracion(String fecha);

    @Query("select new co.edu.uniquindio.proyecto.DTO.productoDTO(p.nombreProducto, p.descripcionProducto, p.fechaCosecha, p.fechaMaduracion, p.cantidadProducto, p.disponible, p.precioProduccion, p.precioVentaProducto) from producto p where p.nombreProducto =:nombre")
    List<productoDTO> listaDTO(String nombre);
}

