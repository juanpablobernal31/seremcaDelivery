package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class venta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idVenta;

    @ManyToOne
    private persona idPersonaVenta;

    private LocalDateTime fechaVenta;

    @Column(nullable = false)
    @PositiveOrZero
    private float precioVenta;

    @Column(nullable = false)
    @PositiveOrZero
    private float imuestoVenta;



    @OneToMany(mappedBy = "idVentaDetalleVenta")
    private List<detalleVenta> detalleVentaList;

}
