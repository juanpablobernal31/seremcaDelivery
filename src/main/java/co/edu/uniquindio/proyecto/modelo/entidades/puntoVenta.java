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
public class puntoVenta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idPuntoVenta;

    @Enumerated(EnumType.STRING)
    private departamento departametoPV;

    @Column(nullable = false)
    @PositiveOrZero
    private int municipioPV;

    @PositiveOrZero
    private int capacidadAlmacenamiento;

    @Column(nullable = false)
    private String nombrePuntoVenta;

}
