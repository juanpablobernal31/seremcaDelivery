package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;


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
    private int idCategoriaProducto;

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

}
