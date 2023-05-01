package co.edu.uniquindio.proyecto.entidades;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class categoria implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idCategoria;

    @Column(nullable = false)
    private String nombreCategoria;

    @Column(nullable = false)
    private String descripcionCategoria;

    @Column(nullable = false)
    @PositiveOrZero
    private int diasMaduracion;

    @Column(nullable = false)
    private String unidadMedida;


    @OneToMany(mappedBy = "idCatProducto")
    @ToString.Exclude
    private List<producto> productoCategoriaList;


    @Builder
    public categoria(String nombreCategoria, String descripcionCategoria, int diasMaduracion, String unidadMedida) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.diasMaduracion = diasMaduracion;
        this.unidadMedida = unidadMedida;
    }
}
