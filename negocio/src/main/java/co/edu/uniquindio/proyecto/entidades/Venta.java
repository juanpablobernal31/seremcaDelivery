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
public class Venta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idVenta;

    @ManyToOne
    private Persona idPersonaVenta;

    @Column(nullable = false)
    private String fechaVenta;

    @Column(nullable = false)
    @PositiveOrZero
    private float precioVenta;


    @OneToMany(mappedBy = "idVentaDetalleVenta")
    @ToString.Exclude
    private List<DetalleVenta> detalleVentaList;

    @Builder
    public Venta(Persona idPersonaVenta, String fechaVenta, float precioVenta) {
        this.idPersonaVenta = idPersonaVenta;
        this.fechaVenta = fechaVenta;
        this.precioVenta = precioVenta;
    }
}
