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
public class persona implements Serializable {
    
    //atributos


    @Id
    @EqualsAndHashCode.Include
    private int idPersona;

    @Enumerated(EnumType.STRING)
    private rol idRolPersona;

    @Column(nullable = false)
    private String nombrePersona;

    @Column(nullable = false)
    private String direccionPersona;

    @Column(nullable = false)
    private String ciudadPersona;

    @Column(nullable = false)
    private String telefonoPersona;

    @Column(nullable = false)
    private String contraseña;
}