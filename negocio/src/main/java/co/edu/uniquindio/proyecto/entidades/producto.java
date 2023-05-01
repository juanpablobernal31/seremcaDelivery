package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class producto implements Serializable {

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
    private proveedor idProveProducto;

    @ManyToOne
    private categoria idCatProducto;

    @OneToMany(mappedBy = "idProductoDetalleVenta")
    @ToString.Exclude
    private List<detalleVenta> productoDetaVentaList;

    @Builder
    public producto( int cantidadProducto, int disponible, float precioProduccion, float precioVentaProducto, String nombreProducto, String descripcionProducto, String fechaCosecha, String fechaMaduracion, proveedor idProveProducto, categoria idCatProducto) {

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
