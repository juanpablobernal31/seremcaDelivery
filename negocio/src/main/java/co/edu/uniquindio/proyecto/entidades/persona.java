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
public class persona implements Serializable {
    
    //atributos


    @Id
    @EqualsAndHashCode.Include
    private int idPersona;

    @Column(nullable = false)
    private int rolPersona;

    @Column(nullable = false)
    private String nombrePersona;

    @Column(nullable = false)
    private String direccionPersona;

    @Column(nullable = false)
    private String ciudadPersona;

    @Column(nullable = false)
    private String telefonoPersona;

    @Column(nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "idPersonaEnvio")
    @ToString.Exclude // --> agregar esta sentencia a todos los MANY_TO_ONE
    private List<envio> envios;

    @OneToMany(mappedBy = "idPersonaVenta")
    @ToString.Exclude // --> agregar esta sentencia a todos los MANY_TO_ONE
    private List<venta> ventas;


    @Builder
    public persona(int idPersona, int rolPersona, String nombrePersona, String direccionPersona, String ciudadPersona, String telefonoPersona, String contrasena) {
        this.idPersona = idPersona;
        this.rolPersona = rolPersona;
        this.nombrePersona = nombrePersona;
        this.direccionPersona = direccionPersona;
        this.ciudadPersona = ciudadPersona;
        this.telefonoPersona = telefonoPersona;
        this.contrasena = contrasena;
    }
}