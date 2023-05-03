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
public class Departamento implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idDepartamento;

    @Column(nullable = false)
    private String nombreDepartamento;

    @OneToMany(mappedBy = "idDepartMunicipio")
    @ToString.Exclude
    private List<Municipio> municipios;

    @OneToMany(mappedBy = "departamentoProveedor")
    @ToString.Exclude
    private List<Proveedor> proveedores;

    @OneToMany(mappedBy = "idDepartametoPV")
    @ToString.Exclude
    private List<PuntoVenta> puntosVenta;


    @Builder
    public Departamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
