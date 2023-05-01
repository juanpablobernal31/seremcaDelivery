package co.edu.uniquindio.proyecto.entidades;
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
public class departamento implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idDepartamento;

    @Column(nullable = false)
    private String nombreDepartamento;

    @OneToMany(mappedBy = "idDepartMunicipio")
    @ToString.Exclude
    private List<municipio> municipios;

    @OneToMany(mappedBy = "departamentoProveedor")
    @ToString.Exclude
    private List<proveedor> proveedores;

    @OneToMany(mappedBy = "idDepartametoPV")
    @ToString.Exclude
    private List<puntoVenta> puntosVenta;


    @Builder
    public departamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
