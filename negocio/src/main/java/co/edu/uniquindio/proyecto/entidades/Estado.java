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
public class Estado implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idEstado;

    @Column(nullable = false)
    private String nombreEstado;

    @Column(nullable = false)
    private String descripEstado;


    @OneToMany(mappedBy = "estadosEnvio")
    @ToString.Exclude
    private List<Envio> envioEstado;


    @Builder
    public Estado(String nombreEstado, String descripEstado) {
        this.nombreEstado = nombreEstado;
        this.descripEstado = descripEstado;
    }
}
