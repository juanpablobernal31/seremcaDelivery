package co.edu.uniquindio.proyecto.entidades;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Producto implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idProducto;


    @PositiveOrZero
    private int cantidadProducto;

    @PositiveOrZero
    private int disponible;

    @PositiveOrZero
    private float precioProduccion;

    @PositiveOrZero
    private float precioVentaProducto;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private String descripcionProducto;

    @Column(nullable = false)
    private String fechaCosecha;

    @Column(nullable = false)
    private String fechaMaduracion;


    @ManyToOne
    private Proveedor idProveProducto;

    @ManyToOne
    private Categoria idCatProducto;

    @OneToMany(mappedBy = "idProductoDetalleVenta")
    @ToString.Exclude
    private List<DetalleVenta> productoDetaVentaList;

    @Builder
    public Producto(int cantidadProducto, int disponible, float precioProduccion, float precioVentaProducto, String nombreProducto, String descripcionProducto, String fechaCosecha, String fechaMaduracion, Proveedor idProveProducto, Categoria idCatProducto) {

        this.cantidadProducto = cantidadProducto;
        this.disponible = disponible;
        this.precioProduccion = precioProduccion;
        this.precioVentaProducto = precioVentaProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.fechaCosecha = fechaCosecha;
        this.fechaMaduracion = fechaMaduracion;
        this.idProveProducto = idProveProducto;
        this.idCatProducto = idCatProducto;
    }
}
