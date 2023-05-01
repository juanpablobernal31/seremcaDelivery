package co.edu.uniquindio.proyecto.entidades;

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

    @ManyToOne
    private puntoVenta idPuntoOrigenEnvio;

    @Column(nullable = false)
    private int idVentaEnvio;

    @ManyToOne
    private persona idPersonaEnvio;

    @ManyToOne
    private estado estadosEnvio;

    @Column(nullable = false)
    private String telefonoEnvio;

    @Column(nullable = false)
    private String fechaEnvio;


    @Builder
    public envio(String direccionEnvio, puntoVenta idPuntoOrigenEnvio, int idVentaEnvio, persona idPersonaEnvio, estado estadosEnvio, String telefonoEnvio, String fechaEnvio) {
        this.direccionEnvio = direccionEnvio;
        this.idPuntoOrigenEnvio = idPuntoOrigenEnvio;
        this.idVentaEnvio = idVentaEnvio;
        this.idPersonaEnvio = idPersonaEnvio;
        this.estadosEnvio = estadosEnvio;
        this.telefonoEnvio = telefonoEnvio;
        this.fechaEnvio = fechaEnvio;
    }
}
