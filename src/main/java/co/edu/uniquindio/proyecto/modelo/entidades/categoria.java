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
public class categoria implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idCategoria;

    @Column(nullable = false)
    private String nombreCategoria;

    @Column(nullable = false)
    private String descripcionCategoria;

    @Column(nullable = false)
    @PositiveOrZero
    private int diasMaduracion;

    @Column(nullable = false)
    @PositiveOrZero
    private String unidadMedida;


}
