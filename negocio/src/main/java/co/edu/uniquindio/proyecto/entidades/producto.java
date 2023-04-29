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


    @Column(nullable = false)
    private int idProveerdorProducto;

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
    private LocalDate fechaCosecha;

    @Column(nullable = false)
    private LocalDate fechaMaduracion;


    @ManyToOne
    private proveedor idProveProducto;

    @ManyToOne
    private categoria idCatProducto;

    @OneToMany(mappedBy = "idProductoDetalleVenta")
    private List<detalleVenta> productoDetaVentaList;

    @Builder
    public producto(int idProveerdorProducto, int cantidadProducto, int disponible, float precioProduccion, float precioVentaProducto, String nombreProducto, String descripcionProducto, LocalDate fechaCosecha, LocalDate fechaMaduracion, proveedor idProveProducto, categoria idCatProducto) {
        this.idProveerdorProducto = idProveerdorProducto;
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
