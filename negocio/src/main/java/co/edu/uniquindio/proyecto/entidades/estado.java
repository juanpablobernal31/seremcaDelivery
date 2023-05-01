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
public class estado implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idEstado;

    @Column(nullable = false)
    private String nombreEstado;

    @Column(nullable = false)
    private String descripEstado;


    @OneToMany(mappedBy = "estadosEnvio")
    @ToString.Exclude
    private List<envio> envioEstado;


    @Builder
    public estado(String nombreEstado, String descripEstado) {
        this.nombreEstado = nombreEstado;
        this.descripEstado = descripEstado;
    }
}
