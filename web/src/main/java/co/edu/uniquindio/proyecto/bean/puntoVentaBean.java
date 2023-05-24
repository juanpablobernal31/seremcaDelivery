package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.entidades.Municipio;
import co.edu.uniquindio.proyecto.entidades.PuntoVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.uniquindio.proyecto.servicios.adminServicio;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class puntoVentaBean implements Serializable {

    private PuntoVenta puntoVenta;

    @Autowired
    private adminServicio adminServicio;

    private List<PuntoVenta> puntoVentas;

    private List<Departamento> departamentos;

    private List<Municipio> municipios;
    private List<PuntoVenta> puntosVentaSelecionado;

    public puntoVentaBean(adminServicio adminServicio){
        this.adminServicio = adminServicio;
        puntoVentas = adminServicio.listarPuntoVenta();
        municipios = adminServicio.listarMunicipio();
        departamentos = adminServicio.listarDepartamento();
        puntosVentaSelecionado = new ArrayList<>();

    }

    @PostConstruct
    public  void    init(){ puntoVenta = new PuntoVenta();}

    public  void agregarPuntoVenta(){
        try{
            if (puntoVenta!=null){
                adminServicio.crearPuntoVenta(puntoVenta);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Categoria agregada.");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            }else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Los valores son incorrectos");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            }
        }catch (Exception e){

        }
    }

    public void  borrarPuntoVenta(){
        try {
            puntosVentaSelecionado.forEach(p->{
                try {
                    adminServicio.eliminarPuntoVenta(p.getIdPuntoVenta());
                    puntoVentas.remove(p);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            System.out.println(e.toString());
            FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
        }

    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public List<PuntoVenta> getPuntoVentas() {
        return puntoVentas;
    }

    public void setPuntoVentas(List<PuntoVenta> puntoVentas) {
        this.puntoVentas = puntoVentas;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<PuntoVenta> getPuntosVentaSelecionado() {
        return puntosVentaSelecionado;
    }

    public void setPuntosVentaSelecionado(List<PuntoVenta> puntosVentaSelecionado) {
        this.puntosVentaSelecionado = puntosVentaSelecionado;
    }
}
