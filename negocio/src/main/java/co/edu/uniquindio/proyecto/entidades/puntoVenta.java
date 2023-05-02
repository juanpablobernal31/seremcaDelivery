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
public class puntoVenta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idPuntoVenta;


    @PositiveOrZero
    private int capacidadAlmacenamiento;

    @Column(nullable = false)
    private String nombrePuntoVenta;

    @ManyToOne
    private municipio idMunicipioPv;

    @ManyToOne
    private departamento idDepartametoPV;

    @OneToMany(mappedBy = "idPuntoOrigenEnvio")
    @ToString.Exclude
    private List<envio> puntoVentaEnvios;


    @Builder
    public puntoVenta(departamento idDepartametoPV, int capacidadAlmacenamiento, String nombrePuntoVenta, municipio idMunicipioPv) {
        this.idDepartametoPV = idDepartametoPV;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.nombrePuntoVenta = nombrePuntoVenta;
        this.idMunicipioPv = idMunicipioPv;
    }
}
