package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

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
    private List<puntoVenta> municipioPuntoVenta;

    @OneToMany(mappedBy = "idMunicipioProv")
    private List<proveedor> municipioProveedor;

}
