package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class detalleVenta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idDetalleVenta;


    @ManyToOne
    private venta idVentaDetalleVenta;


    @ManyToOne
    private producto idProductoDetalleVenta;


    @PositiveOrZero
    private int precioTotal;

    @PositiveOrZero
    private int descuentos;

    @PositiveOrZero
    private int cantidadProducto;
}
