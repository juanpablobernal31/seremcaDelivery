package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Proveedor implements Serializable {

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
    private EsAsociacion esAsociacion;

    @PositiveOrZero
    private int nivelMar;

    @Column(nullable = false)
    private String nombreProveedor;

    @Column(nullable = false)
    private String cedulaNit;

    @ManyToOne
    private Municipio idMunicipioProv;

    @ManyToOne
    private Departamento departamentoProveedor;

    @OneToMany(mappedBy = "idProveProducto")
    @ToString.Exclude
    private List<Producto> productoProveedorList;



    @Builder
    public Proveedor(int promedioProveedor, int ultimaCosecha, int numeroCosecha, EsAsociacion esAsociacion, int nivelMar, String nombreProveedor, String cedulaNit, Municipio idMunicipioProv, Departamento departamentoProveedor) {
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
