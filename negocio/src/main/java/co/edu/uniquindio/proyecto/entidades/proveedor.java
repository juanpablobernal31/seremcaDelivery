package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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


    @PositiveOrZero
    private int promedioProveedor;

    @PositiveOrZero
    private int ultimaCosecha;

    @PositiveOrZero
    private int numeroCosecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private esAsociacion esAsociacion;

    @PositiveOrZero
    private int nivelMar;

    @Column(nullable = false)
    private String nombreProveedor;

    @Column(nullable = false)
    private String cedulaNit;

    @ManyToOne
    private municipio idMunicipioProv;

    @ManyToOne
    private departamento departamentoProveedor;

    @OneToMany(mappedBy = "idProveProducto")
    private List<producto> productoProveedorList;



    @Builder
    public proveedor(int promedioProveedor, int ultimaCosecha, int numeroCosecha, co.edu.uniquindio.proyecto.entidades.esAsociacion esAsociacion, int nivelMar, String nombreProveedor, String cedulaNit, municipio idMunicipioProv, departamento departamentoProveedor) {
        this.promedioProveedor = promedioProveedor;
        this.ultimaCosecha = ultimaCosecha;
        this.numeroCosecha = numeroCosecha;
        this.esAsociacion = esAsociacion;
        this.nivelMar = nivelMar;
        this.nombreProveedor = nombreProveedor;
        this.cedulaNit = cedulaNit;
        this.idMunicipioProv = idMunicipioProv;
        this.departamentoProveedor = departamentoProveedor;
    }
}