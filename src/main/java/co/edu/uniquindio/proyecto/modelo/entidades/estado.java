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
public class estado implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idEstado;

    @Column(nullable = false)
    private String nombreEstado;

    @Column(nullable = false)
    private String descripEstado;


    @OneToMany(mappedBy = "estadosEnvio")
    private List<envio> envioEstado;
}
