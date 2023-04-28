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
public class persona implements Serializable {
    
    //atributos


    @Id
    @EqualsAndHashCode.Include
    private int idPersona;

    @ManyToOne
    private rol rolPersona;

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

    @OneToMany(mappedBy = "idPersonaEnvio")
    private List<envio> envios;

    @OneToMany(mappedBy = "idPersonaVenta")
    private List<venta> ventas;
}