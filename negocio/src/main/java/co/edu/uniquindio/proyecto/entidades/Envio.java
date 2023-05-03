package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Envio implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idEnvio;

    @Column(nullable = false)
    private String direccionEnvio;

    @ManyToOne
    private PuntoVenta idPuntoOrigenEnvio;

    @Column(nullable = false)
    private int idVentaEnvio;

    @ManyToOne
    private Persona idPersonaEnvio;

    @ManyToOne
    private Estado estadosEnvio;

    @Column(nullable = false)
    private String telefonoEnvio;

    @Column(nullable = false)
    private String fechaEnvio;


    @Builder
    public Envio(String direccionEnvio, PuntoVenta idPuntoOrigenEnvio, int idVentaEnvio, Persona idPersonaEnvio, Estado estadosEnvio, String telefonoEnvio, String fechaEnvio) {
        this.direccionEnvio = direccionEnvio;
        this.idPuntoOrigenEnvio = idPuntoOrigenEnvio;
        this.idVentaEnvio = idVentaEnvio;
        this.idPersonaEnvio = idPersonaEnvio;
        this.estadosEnvio = estadosEnvio;
        this.telefonoEnvio = telefonoEnvio;
        this.fechaEnvio = fechaEnvio;
    }
}
