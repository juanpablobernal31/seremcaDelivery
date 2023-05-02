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
public class municipio implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idMunicipio;


    @Column(nullable = false)
    private String nombremunicipio;


    @ManyToOne
    private departamento idDepartMunicipio;

    @OneToMany(mappedBy = "idMunicipioPv")
    @ToString.Exclude
    private List<puntoVenta> municipioPuntoVenta;

    @OneToMany(mappedBy = "idMunicipioProv")
    @ToString.Exclude
    private List<proveedor> municipioProveedor;


    @Builder
    public municipio(String nombremunicipio, departamento idDepartMunicipio) {
        this.nombremunicipio = nombremunicipio;
        this.idDepartMunicipio = idDepartMunicipio;
    }
}
