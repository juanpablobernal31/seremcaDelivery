package co.edu.uniquindio.proyecto.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ProductoDTO {
    private String nombreProduct;
    private String descripcionProducto;
    private String fechaCosecha;
    private String fechaMaduracion;
    private int cantidadProducto;
    private int disponible;
    private float precioProduccion;
    private float precioVentaProducto;

    public ProductoDTO(String nombreProduct, String descripcionProducto, String fechaCosecha, String fechaMaduracion, int cantidadProducto, int disponible, float precioProduccion, float precioVentaProducto) {
        this.nombreProduct = nombreProduct;
        this.descripcionProducto = descripcionProducto;
        this.fechaCosecha = fechaCosecha;
        this.fechaMaduracion = fechaMaduracion;
        this.cantidadProducto = cantidadProducto;
        this.disponible = disponible;
        this.precioProduccion = precioProduccion;
        this.precioVentaProducto = precioVentaProducto;
    }
}
