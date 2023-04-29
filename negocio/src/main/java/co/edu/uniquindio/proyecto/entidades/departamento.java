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
    private List<municipio> municipios;

    @OneToMany(mappedBy = "departamentoProveedor")
    private List<proveedor> proveedores;


    @Builder
    public departamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}