package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class DetalleVenta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idDetalleVenta;


    @ManyToOne
    private Venta idVentaDetalleVenta;


    @ManyToOne
    private Producto idProductoDetalleVenta;


    @PositiveOrZero
    private float precioTotal;

    @PositiveOrZero
    private int descuentos;

    @PositiveOrZero
    private int cantidadProducto;


    @Builder
    public DetalleVenta(Venta idVentaDetalleVenta, Producto idProductoDetalleVenta, float precioTotal, int descuentos, int cantidadProducto) {
        this.idVentaDetalleVenta = idVentaDetalleVenta;
        this.idProductoDetalleVenta = idProductoDetalleVenta;
        this.precioTotal = precioTotal;
        this.descuentos = descuentos;
        this.cantidadProducto = cantidadProducto;
    }
}
