package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Column(nullable = false)
    private String fechaVenta;

    @Column(nullable = false)
    @PositiveOrZero
    private float precioVenta;


    @OneToMany(mappedBy = "idVentaDetalleVenta")
    @ToString.Exclude
    private List<detalleVenta> detalleVentaList;

    @Builder
    public venta(persona idPersonaVenta, String fechaVenta, float precioVenta) {
        this.idPersonaVenta = idPersonaVenta;
        this.fechaVenta = fechaVenta;
        this.precioVenta = precioVenta;
    }
}
