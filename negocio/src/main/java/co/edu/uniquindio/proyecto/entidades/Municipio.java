package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Municipio implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idMunicipio;


    @Column(nullable = false)
    private String nombremunicipio;


    @ManyToOne
    private Departamento idDepartMunicipio;

    @OneToMany(mappedBy = "idMunicipioPv")
    @ToString.Exclude
    private List<PuntoVenta> municipioPuntoVenta;

    @OneToMany(mappedBy = "idMunicipioProv")
    @ToString.Exclude
    private List<Proveedor> municipioProveedor;


    @Builder
    public Municipio(String nombremunicipio, Departamento idDepartMunicipio) {
        this.nombremunicipio = nombremunicipio;
        this.idDepartMunicipio = idDepartMunicipio;
    }
}
