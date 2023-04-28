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

    @Column(nullable = false)
    @PositiveOrZero
    private int idVentaDetalleVenta;

    @Column(nullable = false)
    private int idProductoVenta;

    @PositiveOrZero
    private int precioTotal;

    @PositiveOrZero
    private int descuentos;

    @PositiveOrZero
    private int cantidadProducto;
}
