package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class envio implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idEnvio;

    @Column(nullable = false)
    private String direccionEnvio;

    @ManyToOne
    private puntoVenta idPuntoOrigenEnvio;

    @Column(nullable = false)
    private int idVentaEnvio;

    @ManyToOne
    private persona idPersonaEnvio;

    @ManyToOne
    private estado estadosEnvio;

    @Column(nullable = true)
    private String telefonoEnvio;


    private LocalDate fechaEnvio;

}
