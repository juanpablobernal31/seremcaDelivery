package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.cantidadProducto=:cantidad")
    List<Producto> productosBycantidad(int cantidad);

    @Query("select p from Producto p where p.disponible=:cantidad")
    List<Producto> productosBydisponibes(int cantidad);

    @Query("select p from Producto p where p.precioVentaProducto=:precio")
    List<Producto> findproductosByPrecioVentaProducto(float precio);

    Producto findByNombreProducto(String nombre);

    @Query("select  p from Producto p where p.fechaCosecha=:fecha")
    List<Producto> findByFechaCosecha(String fecha);

    @Query("select  p from Producto p where p.fechaMaduracion=:fecha")
    List<Producto> findByFechaMaduracion(String fecha);


}

