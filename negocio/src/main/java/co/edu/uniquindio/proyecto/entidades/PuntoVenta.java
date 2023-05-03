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
public class PuntoVenta implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idPuntoVenta;


    @PositiveOrZero
    private int capacidadAlmacenamiento;

    @Column(nullable = false)
    private String nombrePuntoVenta;

    @ManyToOne
    private Municipio idMunicipioPv;

    @ManyToOne
    private Departamento idDepartametoPV;

    @OneToMany(mappedBy = "idPuntoOrigenEnvio")
    @ToString.Exclude
    private List<Envio> puntoVentaEnvios;


    @Builder
    public PuntoVenta(Departamento idDepartametoPV, int capacidadAlmacenamiento, String nombrePuntoVenta, Municipio idMunicipioPv) {
        this.idDepartametoPV = idDepartametoPV;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.nombrePuntoVenta = nombrePuntoVenta;
        this.idMunicipioPv = idMunicipioPv;
    }
}
