package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

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

    @Column(nullable = false)
    private int idPuntoVentaOrigen;

    @Column(nullable = false)
    private int idVentaEnvio;

    @Column(nullable = false)
    private int idClienteEnvio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private estado idEstadoEnvio;

    @Column(nullable = true)
    private String telefonoEnvio;


    private LocalDate fechaEnvio;

}
