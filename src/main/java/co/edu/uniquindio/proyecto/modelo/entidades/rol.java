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
public class rol{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idRol;

    @Column(nullable = false)
    private String nombreRol;

    @OneToMany(mappedBy = "rolPersona")
    private List<persona> personas;
}
