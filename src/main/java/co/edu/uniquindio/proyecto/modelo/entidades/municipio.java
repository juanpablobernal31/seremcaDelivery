package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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

    @Enumerated(EnumType.STRING)
    private departamento departamentoMunicipio;

    @Column(nullable = false)
    private String nombremunicipio;

}
