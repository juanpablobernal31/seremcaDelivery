package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class puntoVenta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idPuntoVenta;

    @Column(nullable = false)
    private int idDepartametoPV;

    @Column(nullable = false)
    @PositiveOrZero
    private int municipioPV;

    @PositiveOrZero
    private int capacidadAlmacenamiento;

    @Column(nullable = false)
    private String nombrePuntoVenta;

    @ManyToOne
    private municipio idMunicipioPv;

    @OneToMany(mappedBy = "idPuntoOrigenEnvio")
    private List<envio> puntoVentaEnvios;

}
