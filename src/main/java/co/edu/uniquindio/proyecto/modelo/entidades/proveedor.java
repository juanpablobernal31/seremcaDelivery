package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class proveedor implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int idProveedor;

    @Column(nullable = false)
    private int epartamentoProveedor;


    @Column(nullable = false)
    @PositiveOrZero
    private int municipioProveedor;


    @PositiveOrZero
    private int promedioProveedor;

    @PositiveOrZero
    private int ultimaCosecha;

    @PositiveOrZero
    private int numeroCosecha;

    @PositiveOrZero
    private int esAsociacion;

    @PositiveOrZero
    private int nivelMar;

    @Column(nullable = false)
    private String nombreProveedor;

    @Column(nullable = false)
    private String cedulaNit;

}
