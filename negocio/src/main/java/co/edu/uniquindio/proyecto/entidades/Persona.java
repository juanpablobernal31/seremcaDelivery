package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Persona implements Serializable {
    
    //atributos


    @Id
    @EqualsAndHashCode.Include
    private int idPersona;

    @Column(nullable = false)
    private int rolPersona = 0;

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
    private List<Envio> envios;

    @OneToMany(mappedBy = "idPersonaVenta")
    @ToString.Exclude // --> agregar esta sentencia a todos los MANY_TO_ONE
    private List<Venta> Ventas;


    @Builder
    public Persona(int idPersona, String nombrePersona, String direccionPersona, String ciudadPersona, String telefonoPersona, String contrasena) {
        this.idPersona = idPersona;
        this.rolPersona = 0;
        this.nombrePersona = nombrePersona;
        this.direccionPersona = direccionPersona;
        this.ciudadPersona = ciudadPersona;
        this.telefonoPersona = telefonoPersona;
        this.contrasena = contrasena;
    }
}